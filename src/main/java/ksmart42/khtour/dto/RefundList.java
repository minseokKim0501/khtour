package ksmart42.khtour.dto;

public class RefundList {
	
	private String refApplyCode;
	private String memberId;
	private String refRuleCode;
	private String pmtCode;
	private String pmtWayCode;
	private String refApplyReason;
	private String refApplyDate;
	public String getRefApplyCode() {
		return refApplyCode;
	}
	public void setRefApplyCode(String refApplyCode) {
		this.refApplyCode = refApplyCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRefRuleCode() {
		return refRuleCode;
	}
	public void setRefRuleCode(String refRuleCode) {
		this.refRuleCode = refRuleCode;
	}
	public String getPmtCode() {
		return pmtCode;
	}
	public void setPmtCode(String pmtCode) {
		this.pmtCode = pmtCode;
	}
	public String getPmtWayCode() {
		return pmtWayCode;
	}
	public void setPmtWayCode(String pmtWayCode) {
		this.pmtWayCode = pmtWayCode;
	}
	public String getRefApplyReason() {
		return refApplyReason;
	}
	public void setRefApplyReason(String refApplyReason) {
		this.refApplyReason = refApplyReason;
	}
	public String getRefApplyDate() {
		return refApplyDate;
	}
	public void setRefApplyDate(String refApplyDate) {
		this.refApplyDate = refApplyDate;
	}
	@Override
	public String toString() {
		return "Refund [refApplyCode=" + refApplyCode + ", memberId=" + memberId + ", refRuleCode=" + refRuleCode
				+ ", pmtCode=" + pmtCode + ", pmtWayCode=" + pmtWayCode + ", refApplyReason=" + refApplyReason
				+ ", refApplyDate=" + refApplyDate + "]";
	}
	

}
