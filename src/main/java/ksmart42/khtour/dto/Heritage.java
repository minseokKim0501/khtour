package ksmart42.khtour.dto;

public class Heritage {
	//heritage_code 
	//member_id 
	//heritage_category
	//heritage_name 
	//heritage_Sub_name 
	//heritage_location 
	//heritage_era
	//heritage_designation 
	//heritage_classification 
	//heritage_detail 
	//heritage_owner
	//heritage_manager
	//heritage_area
	
	private String  heritageCode;
	private String  memberId;
	private String  heritageCategory;
	private String  heritageName;
	private String  heritageSubName;
	private String  heritageLocation;
	private String  heritageEra;
	private String  heritageDesignation;
	private String  heritageClassification;
	private String  heritageDetail;
	private String  heritageOwner;
	private String  heritageManager;
	private String  heritageArea;
	
	private String  heritageImagePath;
	
	/*
	 * heritageDesignation dd/mm/y -> ymmdd로 형식 변환 코드
	 */
	/* private String newHeritageDesignationFormat(String heritageDesignation) {
		if(Objects.nonNull(heritageDesignation) && !heritageDesignation.isEmpty() && heritageDesignation.indexOf("/") > -1) {
			String[] dateArray = heritageDesignation.split("/");
			if(dateArray.length == 3) {				
				StringJoiner ji = new StringJoiner("");
				for(int i=dateArray.length - 1; i >= 0; i--) {
					ji.add(dateArray[i]);
				}
				heritageDesignation = ji.toString();
			}
		}
		return heritageDesignation;	
	}
	*/
	
	public String getHeritageCode() {
		return heritageCode;
	}

	public void setHeritageCode(String heritageCode) {
		this.heritageCode = heritageCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getHeritageCategory() {
		return heritageCategory;
	}

	public void setHeritageCategory(String heritageCategory) {
		this.heritageCategory = heritageCategory;
	}

	public String getHeritageName() {
		return heritageName;
	}

	public void setHeritageName(String heritageName) {
		this.heritageName = heritageName;
	}

	public String getHeritageSubName() {
		return heritageSubName;
	}

	public void setHeritageSubName(String heritageSubName) {
		this.heritageSubName = heritageSubName;
	}

	public String getHeritageLocation() {
		return heritageLocation;
	}

	public void setHeritageLocation(String heritageLocation) {
		this.heritageLocation = heritageLocation;
	}

	public String getHeritageEra() {
		return heritageEra;
	}

	public void setHeritageEra(String heritageEra) {
		this.heritageEra = heritageEra;
	}

	public String getHeritageDesignation() {
		return heritageDesignation;
	}

	public void setHeritageDesignation(String heritageDesignation) {
		this.heritageDesignation = heritageDesignation;
	}

	public String getHeritageClassification() {
		return heritageClassification;
	}

	public void setHeritageClassification(String heritageClassification) {
		this.heritageClassification = heritageClassification;
	}

	public String getHeritageDetail() {
		return heritageDetail;
	}

	public void setHeritageDetail(String heritageDetail) {
		this.heritageDetail = heritageDetail;
	}

	public String getHeritageOwner() {
		return heritageOwner;
	}

	public void setHeritageOwner(String heritageOwner) {
		this.heritageOwner = heritageOwner;
	}

	public String getHeritageManager() {
		return heritageManager;
	}

	public void setHeritageManager(String heritageManager) {
		this.heritageManager = heritageManager;
	}

	public String getHeritageArea() {
		return heritageArea;
	}

	public void setHeritageArea(String heritageArea) {
		this.heritageArea = heritageArea;
	}

	public String getHeritageImagePath() {
		return heritageImagePath;
	}

	public void setHeritageImagePath(String heritageImagePath) {
		this.heritageImagePath = heritageImagePath;
	}

	@Override
	public String toString() {
		return "Heritage [heritageCode=" + heritageCode + ", memberId=" + memberId + ", heritageCategory="
				+ heritageCategory + ", heritageName=" + heritageName + ", heritageSubName=" + heritageSubName
				+ ", heritageLocation=" + heritageLocation + ", heritageEra=" + heritageEra + ", heritageDesignation="
				+ heritageDesignation + ", heritageClassification=" + heritageClassification + ", heritageDetail="
				+ heritageDetail + ", heritageOwner=" + heritageOwner + ", heritageManager=" + heritageManager
				+ ", heritageArea=" + heritageArea + ", heritageImagePath=" + heritageImagePath + "]";
	}
	
	

}
