package ksmart42.khtour.dto;

public class RecordBoard {
	//record_board_code, 
	//member_id, 
	//record_board_name, 
	//record_board_sub_name, 
	//content, 
	//plan_status_code, 
	//start_date, 
	//end_date, 
	//reg_date, 
	//feed_count, 
	//views,
	//travel_style
	
	private String recordBoardCode;
	private String memberId;
	private String recordBoardName;
	private String recordBoardSubName;
	private String content;
	private String planStatusCode;
	private String startDate;
	private String endDate;
	private String regDate;
	private int feedCount;
	private int views;
	private int commentCount;
	private String travelStyle;
	
	private Member member;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	private String recordBoardImagePath;

	private PlanStatus planStatus;

	public String getRecordBoardCode() {
		return recordBoardCode;
	}

	public void setRecordBoardCode(String recordBoardCode) {
		this.recordBoardCode = recordBoardCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRecordBoardName() {
		return recordBoardName;
	}

	public void setRecordBoardName(String recordBoardName) {
		this.recordBoardName = recordBoardName;
	}

	public String getRecordBoardSubName() {
		return recordBoardSubName;
	}

	public void setRecordBoardSubName(String recordBoardSubName) {
		this.recordBoardSubName = recordBoardSubName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlanStatusCode() {
		return planStatusCode;
	}

	public void setPlanStatusCode(String planStatusCode) {
		this.planStatusCode = planStatusCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getFeedCount() {
		return feedCount;
	}

	public void setFeedCount(int feedCount) {
		this.feedCount = feedCount;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getRecordBoardImagePath() {
		return recordBoardImagePath;
	}

	public void setRecordBoardImagePath(String recordBoardImagePath) {
		this.recordBoardImagePath = recordBoardImagePath;
	}

	public PlanStatus getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(PlanStatus planStatus) {
		this.planStatus = planStatus;
	}

	
	public String getTravelStyle() {
		return travelStyle;
	}

	public void setTravelStyle(String travelStyle) {
		this.travelStyle = travelStyle;
	}
	
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "RecordBoard [recordBoardCode=" + recordBoardCode + ", memberId=" + memberId + ", recordBoardName="
				+ recordBoardName + ", recordBoardSubName=" + recordBoardSubName + ", content=" + content
				+ ", planStatusCode=" + planStatusCode + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", regDate=" + regDate + ", feedCount=" + feedCount + ", views=" + views + ", commentCount="
				+ commentCount + ", travelStyle=" + travelStyle + ", member=" + member + ", recordBoardImagePath="
				+ recordBoardImagePath + ", planStatus=" + planStatus + "]";
	}


	

}
