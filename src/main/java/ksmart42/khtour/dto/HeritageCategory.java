package ksmart42.khtour.dto;

public class HeritageCategory {
	//heritage_category_num
	//heritage_category_name 
	//heritage_category_reg_date
	
	private String heritageCategoryNum;
	private String heritageCategoryName;
	private String heritageCategoryRegDate;
	
	public String getHeritageCategoryNum() {
		return heritageCategoryNum;
	}
	public void setHeritageCategoryNum(String heritageCategoryNum) {
		this.heritageCategoryNum = heritageCategoryNum;
	}
	public String getHeritageCategoryName() {
		return heritageCategoryName;
	}
	public void setHeritageCategoryName(String heritageCategoryName) {
		this.heritageCategoryName = heritageCategoryName;
	}
	public String getHeritageCategoryRegDate() {
		return heritageCategoryRegDate;
	}
	public void setHeritageCategoryRegDate(String heritageCategoryRegDate) {
		this.heritageCategoryRegDate = heritageCategoryRegDate;
	}
	
	@Override
	public String toString() {
		return "HeritageCategory [heritageCategoryNum=" + heritageCategoryNum + ", heritageCategoryName="
				+ heritageCategoryName + ", heritageCategoryRegDate=" + heritageCategoryRegDate + "]";
	}
}
