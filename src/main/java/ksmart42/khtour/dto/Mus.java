package ksmart42.khtour.dto;

public class Mus {
	//대분류코드 대분류종류 고유코드 이름 주소 상세설명 사이트 전화번호 체험활동 유/무 시작시간 종료시간 휴무일
	private String musCode;
	private String musLargeCateCode;
	private String musLargeCateName;
	private String musName;
	private String musAddr;
	private String musDetail;
	private String musSite;
	private String musNum;
	private String musDisclose;
	private String musStart;
	private String musEnd;
	private String musClose;
	
	public String getMusCode() {
		return musCode;
	}
	public void setMusCode(String musCode) {
		this.musCode = musCode;
	}
	public String getMusLargeCateCode() {
		return musLargeCateCode;
	}
	public void setMusLargeCateCode(String musLargeCateCode) {
		this.musLargeCateCode = musLargeCateCode;
	}
	
	public String getMusLargeCateName() {
		return musLargeCateName;
	}
	public void setMusLargeCateName(String musLargeCateName) {
		this.musLargeCateName = musLargeCateName;
	}
	public String getMusName() {
		return musName;
	}
	public void setMusName(String musName) {
		this.musName = musName;
	}
	
	public String getMusAddr() {
		return musAddr;
	}
	public void setMusAddr(String musAddr) {
		this.musAddr = musAddr;
	}
	public String getMusDetail() {
		return musDetail;
	}
	public void setMusDetail(String musDetail) {
		this.musDetail = musDetail;
	}
	public String getMusSite() {
		return musSite;
	}
	public void setMusSite(String musSite) {
		this.musSite = musSite;
	}
	public String getMusNum() {
		return musNum;
	}
	public void setMusNum(String musNum) {
		this.musNum = musNum;
	}
	public String getMusDisclose() {
		return musDisclose;
	}
	public void setMusDisclose(String musDisclose) {
		this.musDisclose = musDisclose;
	}
	public String getMusStart() {
		return musStart;
	}
	public void setMusStart(String musStart) {
		this.musStart = musStart;
	}
	public String getMusEnd() {
		return musEnd;
	}
	public void setMusEnd(String musEnd) {
		this.musEnd = musEnd;
	}
	public String getMusClose() {
		return musClose;
	}
	public void setMusClose(String musClose) {
		this.musClose = musClose;
	}
	@Override
	public String toString() {
		return "Mus [musCode=" + musCode + ", musLargeCateCode=" + musLargeCateCode + ", musLargeCateName="
				+ musLargeCateName + ", musName=" + musName + ", musAddr=" + musAddr + ", musDetail=" + musDetail
				+ ", musSite=" + musSite + ", musNum=" + musNum + ", musDisclose=" + musDisclose + ", musStart="
				+ musStart + ", musEnd=" + musEnd + ", musClose=" + musClose + "]힘들다아아아아악";
	}
	
	
	
}
