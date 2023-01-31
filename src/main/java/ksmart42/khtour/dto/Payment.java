package ksmart42.khtour.dto;

public class Payment {
	
	private String pmtCode;
	private String pmtResvCode;
	private String pmtWayCode;
	private String memberId;
	private int pmtTotalAmount;
	private int pmtPointUse;
	private int pmtSubTotalAmount;
	private int pmtPointGain;
	private String pmtDate;
	private String pmtStatus;
	private String pmtIp;
	public String getPmtCode() {
		return pmtCode;
	}
	public void setPmtCode(String pmtCode) {
		this.pmtCode = pmtCode;
	}
	public String getPmtResvCode() {
		return pmtResvCode;
	}
	public void setPmtResvCode(String pmtResvCode) {
		this.pmtResvCode = pmtResvCode;
	}
	public String getPmtWayCode() {
		return pmtWayCode;
	}
	public void setPmtWayCode(String pmtWayCode) {
		this.pmtWayCode = pmtWayCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getPmtTotalAmount() {
		return pmtTotalAmount;
	}
	public void setPmtTotalAmount(int pmtTotalAmount) {
		this.pmtTotalAmount = pmtTotalAmount;
	}
	public int getPmtPointUse() {
		return pmtPointUse;
	}
	public void setPmtPointUse(int pmtPointUse) {
		this.pmtPointUse = pmtPointUse;
	}
	public int getPmtSubTotalAmount() {
		return pmtSubTotalAmount;
	}
	public void setPmtSubTotalAmount(int pmtSubTotalAmount) {
		this.pmtSubTotalAmount = pmtSubTotalAmount;
	}
	public int getPmtPointGain() {
		return pmtPointGain;
	}
	public void setPmtPointGain(int pmtPointGain) {
		this.pmtPointGain = pmtPointGain;
	}
	public String getPmtDate() {
		return pmtDate;
	}
	public void setPmtDate(String pmtDate) {
		this.pmtDate = pmtDate;
	}
	public String getPmtStatus() {
		return pmtStatus;
	}
	public void setPmtStatus(String pmtStatus) {
		this.pmtStatus = pmtStatus;
	}
	public String getPmtIp() {
		return pmtIp;
	}
	public void setPmtIp(String pmtIp) {
		this.pmtIp = pmtIp;
	}
	@Override
	public String toString() {
		return "Payment [pmtCode=" + pmtCode + ", pmtResvCode=" + pmtResvCode + ", pmtWayCode=" + pmtWayCode
				+ ", memberId=" + memberId + ", pmtTotalAmount=" + pmtTotalAmount + ", pmtPointUse=" + pmtPointUse
				+ ", pmtSubTotalAmount=" + pmtSubTotalAmount + ", pmtPointGain=" + pmtPointGain + ", pmtDate=" + pmtDate
				+ ", pmtStatus=" + pmtStatus + ", pmtIp=" + pmtIp + "]";
	}
	
}
