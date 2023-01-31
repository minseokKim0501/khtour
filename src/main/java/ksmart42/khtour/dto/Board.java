package ksmart42.khtour.dto;

public class Board {
	
	private String boardCode;
	private String boardReRef;
	private String memberId;
	private String boardType;
	private String boardTitle;
	private String boardContent;
	private String boardHit;
	private String boardDate;
	private Member member;
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardReRef() {
		return boardReRef;
	}
	public void setBoardReRef(String boardReRef) {
		this.boardReRef = boardReRef;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(String boardHit) {
		this.boardHit = boardHit;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Board [boardCode=" + boardCode + ", boardReRef=" + boardReRef + ", memberId=" + memberId
				+ ", boardType=" + boardType + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardHit=" + boardHit + ", boardDate=" + boardDate + ", member=" + member + "]";
	}
	
	
	
	
	

}
