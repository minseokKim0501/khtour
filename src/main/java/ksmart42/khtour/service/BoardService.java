package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ksmart42.khtour.dto.Board;
import ksmart42.khtour.dto.BoardReply;
import ksmart42.khtour.mapper.BoardMapper;

@Service
public class BoardService {
	// DI 의존성 주입
	private BoardMapper boardMapper;

	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;

	}

	/**
	 * 코드에 따른 1:1 문의게시판 조회
	 */
	public Board getBoardByCode(String boardCode) {
		return boardMapper.getBoardByCode(boardCode);
	}

	/**
	 * 1:1 문의게시판 등록
	 */
	public void addBoard(Board board) {
		boardMapper.addBoard(board);
	}

	/**
	 * 1:1 문의게시판 목록 조회
	 */
	public List<Board> getBoardList(Map<String, Object> paramMap) {
		List<Board> boardList = boardMapper.getBoardList(paramMap);

		return boardList;
	}

	/**
	 * 1:1 문의게시판 게시글 수정
	 */
	public int modifyBoard(Board board) {
		return boardMapper.modifyBoard(board);
	}

	/**
	 * 1:1 문의게시판 게시글 삭제
	 */
	public int removeBoard(String boardCode) {
		int result = boardMapper.removeBoard(boardCode);

		result += boardMapper.removeBoard(boardCode);

		return result;
	}

	/**
	 * 1:1문의 게시판 조회수 증가
	 */
	public int boardHitUpdate(String boardCode) {
		return boardMapper.boardHitUpdate(boardCode);
	}

	/**
	 * 1:1문의 답글 등록
	 */
	public void addBoardReply(BoardReply boardReply) {

		boardMapper.addBoardReply(boardReply);

	}

	/**
	 * 문의게시글 코드에 따른 답글조회
	 */
	public List<BoardReply> getBoardReplyList(String boardCode) {

		List<BoardReply> BoardReplyList = boardMapper.getBoardReplyList(boardCode);

		return BoardReplyList;
	}

	/**
	 * 코드에 따른 문의게시글 답글 삭제
	 */
	public int deleteReply(String boardReplyCode) {

		int result = boardMapper.deleteReply(boardReplyCode);

		result += boardMapper.deleteReply(boardReplyCode);

		return result;
	}

}
