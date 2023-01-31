package ksmart42.khtour.dto;

public class RefundDetail {
	
	private String refCode;
	private String memberId;
	private String refApplyCode;
	private String refAckDate;
	public String getRefCode() {
		return refCode;
	}
	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRefApplyCode() {
		return refApplyCode;
	}
	public void setRefApplyCode(String refApplyCode) {
		this.refApplyCode = refApplyCode;
	}
	public String getRefAckDate() {
		return refAckDate;
	}
	public void setRefAckDate(String refAckDate) {
		this.refAckDate = refAckDate;
	}
	@Override
	public String toString() {
		return "RefundInfo [refCode=" + refCode + ", memberId=" + memberId + ", refApplyCode=" + refApplyCode
				+ ", refAckDate=" + refAckDate + "]";
	}
	

}
