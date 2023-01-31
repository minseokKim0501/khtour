package ksmart42.khtour.dto;

public class LikesDislikes {


private String likesDislikesCode;
private String memberId;
private String replyCode;
private String regTime;
private String likesDislikesCate;
private String postCode;

public String getPostCode() {
	return postCode;
}
public void setPostCode(String postCode) {
	this.postCode = postCode;
}
public String getLikesDislikesCode() {
	return likesDislikesCode;
}
public void setLikesDislikesCode(String likesDislikesCode) {
	this.likesDislikesCode = likesDislikesCode;
}
public String getMemberId() {
	return memberId;
}
public void setMemberId(String memberId) {
	this.memberId = memberId;
}
public String getReplyCode() {
	return replyCode;
}
public void setReplyCode(String replyCode) {
	this.replyCode = replyCode;
}
public String getRegTime() {
	return regTime;
}
public void setRegTime(String regTime) {
	this.regTime = regTime;
}
public String getLikesDislikesCate() {
	return likesDislikesCate;
}
public void setLikesDislikesCate(String likesDislikesCate) {
	this.likesDislikesCate = likesDislikesCate;
}
@Override
public String toString() {
	return "LikesDislikes [likesDislikesCode=" + likesDislikesCode + ", memberId=" + memberId + ", replyCode="
			+ replyCode + ", regTime=" + regTime + ", likesDislikesCate=" + likesDislikesCate + ", postCode=" + postCode
			+ "]";
}










	
}
