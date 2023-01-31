package ksmart42.khtour.dto;

public class Member {

	private String memberId;
	private String memberPointLevel;
	private int memberTotalPointCode;
	private int memberTotalPointUsed;
	private int memberUsablePoint;
	private String memberPw;
	private String memberStatus;
	private String memberLevel;
	private String memberName;
	private String memberUserName;
	private String memberContact;
	private String memberGender;
	private String memberBirthday;
	private String memberEmail;
	private String memberRegTime;
	private String memberCountry;
	private String memberAbout;
	private String memberAvatarImage;
	private String memberBannerImage;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPointLevel() {
		return memberPointLevel;
	}
	public void setMemberPointLevel(String memberPointLevel) {
		this.memberPointLevel = memberPointLevel;
	}
	public int getMemberTotalPointCode() {
		return memberTotalPointCode;
	}
	public void setMemberTotalPointCode(int memberTotalPointCode) {
		this.memberTotalPointCode = memberTotalPointCode;
	}
	public int getMemberTotalPointUsed() {
		return memberTotalPointUsed;
	}
	public void setMemberTotalPointUsed(int memberTotalPointUsed) {
		this.memberTotalPointUsed = memberTotalPointUsed;
	}
	public int getMemberUsablePoint() {
		return memberUsablePoint;
	}
	public void setMemberUsablePoint(int memberUsablePoint) {
		this.memberUsablePoint = memberUsablePoint;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberUserName() {
		return memberUserName;
	}
	public void setMemberUserName(String memberUserName) {
		this.memberUserName = memberUserName;
	}
	public String getMemberContact() {
		return memberContact;
	}
	public void setMemberContact(String memberContact) {
		this.memberContact = memberContact;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberRegTime() {
		return memberRegTime;
	}
	public void setMemberRegTime(String memberRegTime) {
		this.memberRegTime = memberRegTime;
	}
	public String getMemberCountry() {
		return memberCountry;
	}
	public void setMemberCountry(String memberCountry) {
		this.memberCountry = memberCountry;
	}
	public String getMemberAbout() {
		return memberAbout;
	}
	public void setMemberAbout(String memberAbout) {
		this.memberAbout = memberAbout;
	}
	public String getMemberAvatarImage() {
		return memberAvatarImage;
	}
	public void setMemberAvatarImage(String memberAvatarImage) {
		this.memberAvatarImage = memberAvatarImage;
	}
	public String getMemberBannerImage() {
		return memberBannerImage;
	}
	public void setMemberBannerImage(String memberBannerImage) {
		this.memberBannerImage = memberBannerImage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memberId=");
		builder.append(memberId);
		builder.append(", memberPointLevel=");
		builder.append(memberPointLevel);
		builder.append(", memberTotalPointCode=");
		builder.append(memberTotalPointCode);
		builder.append(", memberTotalPointUsed=");
		builder.append(memberTotalPointUsed);
		builder.append(", memberUsablePoint=");
		builder.append(memberUsablePoint);
		builder.append(", memberPw=");
		builder.append(memberPw);
		builder.append(", memberStatus=");
		builder.append(memberStatus);
		builder.append(", memberLevel=");
		builder.append(memberLevel);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberUserName=");
		builder.append(memberUserName);
		builder.append(", memberContact=");
		builder.append(memberContact);
		builder.append(", memberGender=");
		builder.append(memberGender);
		builder.append(", memberBirthday=");
		builder.append(memberBirthday);
		builder.append(", memberEmail=");
		builder.append(memberEmail);
		builder.append(", memberRegTime=");
		builder.append(memberRegTime);
		builder.append(", memberCountry=");
		builder.append(memberCountry);
		builder.append(", memberAbout=");
		builder.append(memberAbout);
		builder.append(", memberAvatarImage=");
		builder.append(memberAvatarImage);
		builder.append(", memberBannerImage=");
		builder.append(memberBannerImage);
		builder.append("]");
		return builder.toString();
		
	}

}
