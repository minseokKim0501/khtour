package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.Board;
import ksmart42.khtour.dto.BoardReply;
import ksmart42.khtour.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	private BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	/*
	 * 1:1문의 상세페이지 (Get 정보 전달)
	 */
	@GetMapping("/boardDetail")
	public String getBoardDetail(@RequestParam(value = "boardCode") String boardCode, Model model) {

		Board board = boardService.getBoardByCode(boardCode);
		List<BoardReply> BoardReplyList = boardService.getBoardReplyList(boardCode);

		boardService.boardHitUpdate(boardCode);

		model.addAttribute("title", "1:1문의 상세페이지");
		model.addAttribute("board", board);
		model.addAttribute("BoardReplyList", BoardReplyList);

		return "board/boardDetail";
	}

	/*
	 * 1:1문의 조회 (Get 정보 전달)
	 */
	@GetMapping("/boardList")
	public String getboardList(Model model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		List<Board> boardList = boardService.getBoardList(paramMap);

		model.addAttribute("title", "1:1문의 조회페이지");
		model.addAttribute("boardList", boardList);

		return "board/boardList";
	}

	/*
	 * 1:1문의 수정(Post 정보 전달)
	 */
	@PostMapping("/modifyBoard")
	public String modifyBoard(Board board) {

		boardService.modifyBoard(board);
		System.out.println("정보 수정 포스트 전달" + boardService.modifyBoard(board));

		return "redirect:/board/boardList";
	}

	/*
	 * 1:1문의 수정(Get 정보 전달)
	 */
	@GetMapping("/boardModify")
	public String modifyBoard(@RequestParam(value = "boardCode", required = false) String boardCode, Model model) {
		Board board = boardService.getBoardByCode(boardCode);

		model.addAttribute("title", "1:1문의 수정 페이지");
		model.addAttribute("board", board);
		System.out.println("정보 수정 겟방식 전달" + board);

		return "board/boardModify";
	}

	/*
	 * 1:1문의 삭제(post 정보 전달)
	 */
	@GetMapping("/boardRemove")
	public String removeBoard(Board board) {
		String boardCode = board.getBoardCode();

		boardService.removeBoard(boardCode);
		System.out.println("정보 삭제 포스트 전달" + boardService.removeBoard(boardCode));

		return "redirect:/board/boardList";

	}

	/*
	 * 1:1문의 등록(Post 정보 전달)
	 */
	@PostMapping("/boardPost")
	public String addBoard(Board board) {

		boardService.addBoard(board);

		return "redirect:/board/boardList";
	}

	/*
	 * 1:1문의 등록 페이지 이동(Get 정보 전달)
	 */
	@GetMapping("/boardPost")
	public String addBoard(Model model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		List<Board> boardList = boardService.getBoardList(paramMap);

		model.addAttribute("title", "1:1문의 등록");
		model.addAttribute("boardList", boardList);

		return "board/boardPost";
	}

	// 1:1문의 답글 등록(post 정보 전달)
	@PostMapping("/boardDetail")
	public String addBoardReply(BoardReply boardReply, RedirectAttributes attr) {

		boardService.addBoardReply(boardReply);
		log.info(boardReply + "1:1문의 답글 등록");

		attr.addAttribute("boardCode", boardReply.getBoardCode());

		return "redirect:/board/boardDetail";
	}

	// 1:1문의 답글 삭제
	@GetMapping("/deleteReply")
	public String deleteReply(Model model, BoardReply boardReply, RedirectAttributes attr,
			@RequestParam(name = "boardReplyCode", required = false) String boardReplyCode) {

		log.info(boardReply + "리뷰삭제");

		boardService.deleteReply(boardReplyCode);

		attr.addAttribute("boardCode", boardReply.getBoardCode());

		return "redirect:/board/boardList";

	}
}
