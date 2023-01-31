package ksmart42.khtour.dto;

public class RecordBoardComment {

	private String commentNum;
	private String recordBoardCode;
	private String content;
	private String memberId;
	private String regDate;
	public String getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}
	public String getRecordBoardCode() {
		return recordBoardCode;
	}
	public void setRecordBoardCode(String recordBoardCode) {
		this.recordBoardCode = recordBoardCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "RecordBoardComment [commentNum=" + commentNum + ", recordBoardCode=" + recordBoardCode + ", content="
				+ content + ", memberId=" + memberId + ", regDate=" + regDate + "]";
	}
	
	
}
