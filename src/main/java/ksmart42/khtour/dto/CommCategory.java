package ksmart42.khtour.dto;

public class CommCategory {
	private String categoryCode;
	private String categoryName;
	private String regTime;
	private String bannerImg;
	private String totalMemberCnt;
	@Override
	public String toString() {
		return "CommCategory [categoryCode=" + categoryCode + ", categoryName=" + categoryName + ", regTime=" + regTime
				+ ", bannerImg=" + bannerImg + ", totalMemberCnt=" + totalMemberCnt + "]";
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getBannerImg() {
		return bannerImg;
	}
	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}
	public String getTotalMemberCnt() {
		return totalMemberCnt;
	}
	public void setTotalMemberCnt(String totalMemberCnt) {
		this.totalMemberCnt = totalMemberCnt;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
}
