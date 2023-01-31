package ksmart42.khtour.dto;

public class Point {
	/* tb_point_def 포인트 적립 및 사용 기준 */
	private String comment;
	private int pointGetUse;
	/* tb_point_log 포인트 적립 및 사용 목록 */
	private String pointLog;
	private String memberId;
	private String pointCode;
	private String pointAmount;
	private String regTime;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPointGetUse() {
		return pointGetUse;
	}
	public void setPointGetUse(int pointGetUse) {
		this.pointGetUse = pointGetUse;
	}
	public String getPointLog() {
		return pointLog;
	}
	public void setPointLog(String pointLog) {
		this.pointLog = pointLog;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPointCode() {
		return pointCode;
	}
	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	}
	public String getPointAmount() {
		return pointAmount;
	}
	public void setPointAmount(String pointAmount) {
		this.pointAmount = pointAmount;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		return "Point [comment=" + comment + ", pointGetUse=" + pointGetUse + ", pointLog=" + pointLog + ", memberId="
				+ memberId + ", pointCode=" + pointCode + ", pointAmount=" + pointAmount + ", regTime=" + regTime + "]";
	}
	
}
