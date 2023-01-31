package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Board;
import ksmart42.khtour.dto.BoardReply;

@Mapper
public interface BoardMapper {
	
	// 1:1문의게시판 목록조회
	public List<Board> getBoardList(Map<String, Object> paramMap);
		
	// 1:1문의게시판 등록
	public int addBoard(Board board);

	// 1:1문의게시판 조회(1:1문의게시판 코드)
	public Board getBoardByCode(String boardCode);
		
	// 1:1문의게시판 수정(1:1문의게시판코드)
	public int modifyBoard(Board board);
		
	// 1:1문의게시판 삭제
	public int removeBoard(String boardCode);
	
	// 1:1문의 조회수 업데이트
	public int boardHitUpdate(String boardCode);
	
	// 1:1문의 답글 등록
	public void addBoardReply(BoardReply boardReply);
	
	// 1:1문의 답글 조회
	public List<BoardReply> getBoardReplyList(String boardCode);
	
	// 1:1 문의게시글 답글 삭제
	public int deleteReply(String boardReplyCode);
	


	
	

}
