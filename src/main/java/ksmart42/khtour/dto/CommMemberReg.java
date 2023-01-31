package ksmart42.khtour.dto;

public class CommMemberReg {
	private String commMemberRegCode;
	private String commCode;
	private String memberId;
	private String commMemberLevel;
	private String regTime;
	
	
	public String getCommMemberRegCode() {
		return commMemberRegCode;
	}
	public void setCommMemberRegCode(String commMemberRegCode) {
		this.commMemberRegCode = commMemberRegCode;
	}
	public String getCommCode() {
		return commCode;
	}
	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCommMemberLevel() {
		return commMemberLevel;
	}
	public void setCommMemberLevel(String commMemberLevel) {
		this.commMemberLevel = commMemberLevel;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		return "CommMemberReg [commMemberRegCode=" + commMemberRegCode + ", commCode=" + commCode + ", memberId="
				+ memberId + ", commMemberLevel=" + commMemberLevel + ", regTime=" + regTime + "]";
	}
	
	
	
}
