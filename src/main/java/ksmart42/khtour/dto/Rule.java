package ksmart42.khtour.dto;

public class Rule {

	private String ruleCode;
	private String commCode;
	private String title;
	private String detail;
	private String regTime;
	@Override
	public String toString() {
		return "Rule [ruleCode=" + ruleCode + ", commCode=" + commCode + ", title=" + title + ", detail=" + detail
				+ ", regTime=" + regTime + ", reg_time=" + reg_time + "]";
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getCommCode() {
		return commCode;
	}
	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getReg_time() {
		return reg_time;
	}
	public void setReg_time(String reg_time) {
		this.reg_time = reg_time;
	}
	private String reg_time;

	
}
