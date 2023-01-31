package ksmart42.khtour.dto;

public class BoardReply {
	
	private String boardReplyCode;
	private String boardCode;
	private String memberId;
	private String boardReplyContent;
	private String replyDate;
	private Member member;
	
	public String getBoardReplyCode() {
		return boardReplyCode; 
	}
	public void setBoardReplyCode(String boardReplyCode) {
		this.boardReplyCode = boardReplyCode;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBoardReplyContent() {
		return boardReplyContent;
	}
	public void setBoardReplyContent(String boardReplyContent) {
		this.boardReplyContent = boardReplyContent;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "BoardReply [boardReplyCode=" + boardReplyCode + ", boardCode=" + boardCode + ", memberId=" + memberId
				+ ", boardReplyContent=" + boardReplyContent + ", replyDate=" + replyDate + ", member=" + member + "]";
	}
	
	
	

}
