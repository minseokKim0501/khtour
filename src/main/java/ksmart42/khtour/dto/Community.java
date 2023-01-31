package ksmart42.khtour.dto;

public class Community {
	private String commCode;
	private String commName;
	private String memberId;
	private String regDate;
	private String categoryCode;
	private String banner;
	private String avatar;
	private String memberCnt;
	private String onlineMemberCnt;
	private String commDesc;
	
	
	public String getCommCode() {
		return commCode;
	}


	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}


	public String getCommDesc() {
		return commDesc;
	}


	public void setCommDesc(String commDesc) {
		this.commDesc = commDesc;
	}


	@Override
	public String toString() {
		return "Community [commCode=" + commCode + ", commName=" + commName + ", memberId=" + memberId + ", regDate="
				+ regDate + ", categoryCode=" + categoryCode + ", banner=" + banner + ", avatar=" + avatar + ", memberCnt="
				+ memberCnt + ", onlineMemberCnt=" + onlineMemberCnt + ", commDesc=" + commDesc + "]";
	}

	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		System.out.println(memberId + "<- memberId setMemberId Community.java");
		this.memberId = memberId;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		System.out.println(regDate + "<- regDate setRegDate Community.java");
		this.regDate = regDate;
	}


	public String getCommName() {
		return commName;
	}


	public void setCommName(String commName) {
		this.commName = commName;
	}


	public String getCategoryCode() {
		return categoryCode;
	}


	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}


	public String getBanner() {
		return banner;
	}


	public void setBanner(String banner) {
		this.banner = banner;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getMemberCnt() {
		return memberCnt;
	}


	public void setMemberCnt(String memberCnt) {
		this.memberCnt = memberCnt;
	}


	public String getOnlineMemberCnt() {
		return onlineMemberCnt;
	}


	public void setOnlineMemberCnt(String onlineMemberCnt) {
		this.onlineMemberCnt = onlineMemberCnt;
	}


}
