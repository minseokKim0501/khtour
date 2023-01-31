package ksmart42.khtour.dto;


public class AccomReview {
	
	private String ldgReviewCode;
	private String memberId;
	private String ldgCode;
	private String ldgGrade;
	private String ldgCleanliness;
	private String ldgKindness;
	private String ldgConvenience;
	private String ldgLocation;
	private String ldgPriceSta;
	private String reviewContents;
	private String reviewTime;
	private Member member;
	
	public String getLdgReviewCode() {
		return ldgReviewCode;
	}
	public void setLdgReviewCode(String ldgReviewCode) {
		this.ldgReviewCode = ldgReviewCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLdgCode() {
		return ldgCode;
	}
	public void setLdgCode(String ldgCode) {
		this.ldgCode = ldgCode;
	}
	public String getLdgGrade() {
		return ldgGrade;
	}
	public void setLdgGrade(String ldgGrade) {
		this.ldgGrade = ldgGrade;
	}
	public String getLdgCleanliness() {
		return ldgCleanliness;
	}
	public void setLdgCleanliness(String ldgCleanliness) {
		this.ldgCleanliness = ldgCleanliness;
	}
	public String getLdgKindness() {
		return ldgKindness;
	}
	public void setLdgKindness(String ldgKindness) {
		this.ldgKindness = ldgKindness;
	}
	public String getLdgConvenience() {
		return ldgConvenience;
	}
	public void setLdgConvenience(String ldgConvenience) {
		this.ldgConvenience = ldgConvenience;
	}
	public String getLdgLocation() {
		return ldgLocation;
	}
	public void setLdgLocation(String ldgLocation) {
		this.ldgLocation = ldgLocation;
	}
	public String getLdgPriceSta() {
		return ldgPriceSta;
	}
	public void setLdgPriceSta(String ldgPriceSta) {
		this.ldgPriceSta = ldgPriceSta;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "AccomReview [ldgReviewCode=" + ldgReviewCode + ", memberId=" + memberId + ", ldgCode=" + ldgCode
				+ ", ldgGrade=" + ldgGrade + ", ldgCleanliness=" + ldgCleanliness + ", ldgKindness=" + ldgKindness
				+ ", ldgConvenience=" + ldgConvenience + ", ldgLocation=" + ldgLocation + ", ldgPriceSta=" + ldgPriceSta
				+ ", reviewContents=" + reviewContents + ", reviewTime=" + reviewTime + ", member=" + member + "]";
	}
	
	
}
