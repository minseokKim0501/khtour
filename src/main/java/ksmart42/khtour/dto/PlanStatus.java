package ksmart42.khtour.dto;

public class PlanStatus {
	//plan_status_code,
	//plan_status_name,
	//reg_date
	
	
	private String planStatusCode;
	private String planStatusName;
	private String regDate;
	
	
	public String getPlanStatusCode() {
		return planStatusCode;
	}
	public void setPlanStatusCode(String planStatusCode) {
		this.planStatusCode = planStatusCode;
	}
	public String getPlanStatusName() {
		return planStatusName;
	}
	public void setPlanStatusName(String planStatusName) {
		this.planStatusName = planStatusName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "PlanStatus [planStatusCode=" + planStatusCode + ", planStatusName=" + planStatusName + ", regDate="
				+ regDate + ", planStatusCnt=" + "]";
	}
	
}
