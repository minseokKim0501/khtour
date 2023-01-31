package ksmart42.khtour.dto;

public class Feed {
	//feed_code,
	//record_board_code,
	//feed_title,
	//feed_idx,
	//feed_content,
	//feed_time,
	//feed_reg_date,
	//feed_plan_days
	
	private String feedCode;
	private String recordBoardCode;
	private String feedTitle;
	private String feedContent;
	private String feedTime;
	private String regDate;
	private String feedPlanDays;
	
	private String feedImagePath;
	
	public String getFeedImagePath() {
		return feedImagePath;
	}
	public void setFeedImagePath(String feedImagePath) {
		this.feedImagePath = feedImagePath;
	}
	public String getFeedCode() {
		return feedCode;
	}
	public void setFeedCode(String feedCode) {
		this.feedCode = feedCode;
	}
	public String getRecordBoardCode() {
		return recordBoardCode;
	}
	public void setRecordBoardCode(String recordBoardCode) {
		this.recordBoardCode = recordBoardCode;
	}
	public String getFeedTitle() {
		return feedTitle;
	}
	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}
	public String getFeedContent() {
		return feedContent;
	}
	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}
	public String getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(String feedTime) {
		this.feedTime = feedTime;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getFeedPlanDays() {
		return feedPlanDays;
	}
	public void setFeedPlanDays(String feedPlanDays) {
		this.feedPlanDays = feedPlanDays;
	}
	@Override
	public String toString() {
		return "Feed [feedCode=" + feedCode + ", recordBoardCode=" + recordBoardCode + ", feedTitle=" + feedTitle
				+ ", feedIdx=" + ", feedContent=" + feedContent + ", feedTime=" + feedTime + ", regDate="
				+ regDate + ", feedPlanDays=" + feedPlanDays + ", feedImagePath=" + feedImagePath + "]";
	}
	
	
}
