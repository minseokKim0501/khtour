package ksmart42.khtour.dto;


public class Plan {
	//plan_code,
	//plan_name, 
	//start_time, 
	//end_time, 
	//solo_party, 
	//plan_materials, 
	//plan_expenses , 
	//plan_location,
	//reg_date
	
	private String planCode;
	private String memberId;
	private String planName;
	private String startDate;
	private String endDate;
	private String soloParty;
	private String planMaterials;
	private String planExpenses;
	private String planLocation;
	private String regDate;
	
	/*
	 * startDate dd/mm/y -> ymmdd로 형식 변환 코드
	 */
	/* private String newStartDateFormat(String startDate) {
		if(Objects.nonNull(startDate) && !startDate.isEmpty() && startDate.indexOf("/") > -1) {
			String[] dateArray = startDate.split("/");
			if(dateArray.length == 3) {				
				StringJoiner ji = new StringJoiner("");
				for(int i=dateArray.length - 1; i >= 0; i--) {
					ji.add(dateArray[i]);
				}
				startDate = ji.toString();
			}
		}
		return startDate;	
	}
	*/
	/*
	 * endDate: dd/mm/y -> ymmdd로 형식 변환 코드
	 */
	/*
	private String newEndDateFormat(String endDate) {
		if(Objects.nonNull(endDate) && !endDate.isEmpty() && endDate.indexOf("/") > -1) {
			String[] dateArray = endDate.split("/");
			if(dateArray.length == 3) {				
				StringJoiner ji = new StringJoiner("");
				for(int i=dateArray.length - 1; i >= 0; i--) {
					ji.add(dateArray[i]);
				}
				endDate = ji.toString();
			}
		}
		return endDate;	
	}
	*/
	
	
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSoloParty() {
		return soloParty;
	}
	public void setSoloParty(String soloParty) {
		this.soloParty = soloParty;
	}
	public String getPlanMaterials() {
		return planMaterials;
	}
	public void setPlanMaterials(String planMaterials) {
		this.planMaterials = planMaterials;
	}
	public String getPlanExpenses() {
		return planExpenses;
	}
	public void setPlanExpenses(String planExpenses) {
		this.planExpenses = planExpenses;
	}
	public String getPlanLocation() {
		return planLocation;
	}
	public void setPlanLocation(String planLocation) {
		this.planLocation = planLocation;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Plan [planCode=" + planCode + ", memberId=" + memberId + ", planName=" + planName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", soloParty=" + soloParty + ", planMaterials=" + planMaterials
				+ ", planExpenses=" + planExpenses + ", planLocation=" + planLocation + ", regDate=" + regDate + "]";
	}
	
}
