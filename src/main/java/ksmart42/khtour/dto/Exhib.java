package ksmart42.khtour.dto;

public class Exhib {
	//전시회코드 문화재및박물관코드 카테고리코드 카테고리명 이름 시작일 종료일 내용 현황 포스터 홈페이지
	private String exhibCode;
	private String musCode;
	private String exhibCate;
	private String exhibCateName;
	private String exhibName;
	private String exhibStart;
	private String exhibEnd;
	private String exhibCon;
	private String exhibCurrent;
	private String exhibPage;
	
	private String  exhibImagePath;

	public String getExhibCode() {
		return exhibCode;
	}

	public void setExhibCode(String exhibCode) {
		this.exhibCode = exhibCode;
	}

	public String getMusCode() {
		return musCode;
	}

	public void setMusCode(String musCode) {
		this.musCode = musCode;
	}

	public String getExhibCate() {
		return exhibCate;
	}

	public void setExhibCate(String exhibCate) {
		this.exhibCate = exhibCate;
	}

	public String getExhibCateName() {
		return exhibCateName;
	}

	public void setExhibCateName(String exhibCateName) {
		this.exhibCateName = exhibCateName;
	}

	public String getExhibName() {
		return exhibName;
	}

	public void setExhibName(String exhibName) {
		this.exhibName = exhibName;
	}

	public String getExhibStart() {
		return exhibStart;
	}

	public void setExhibStart(String exhibStart) {
		this.exhibStart = exhibStart;
	}

	public String getExhibEnd() {
		return exhibEnd;
	}

	public void setExhibEnd(String exhibEnd) {
		this.exhibEnd = exhibEnd;
	}

	public String getExhibCon() {
		return exhibCon;
	}

	public void setExhibCon(String exhibCon) {
		this.exhibCon = exhibCon;
	}

	public String getExhibCurrent() {
		return exhibCurrent;
	}

	public void setExhibCurrent(String exhibCurrent) {
		this.exhibCurrent = exhibCurrent;
	}

	public String getExhibPage() {
		return exhibPage;
	}

	public void setExhibPage(String exhibPage) {
		this.exhibPage = exhibPage;
	}

	public String getExhibImagePath() {
		return exhibImagePath;
	}

	public void setExhibImagePath(String exhibImagePath) {
		this.exhibImagePath = exhibImagePath;
	}

	@Override
	public String toString() {
		return "Exhib [exhibCode=" + exhibCode + ", musCode=" + musCode + ", exhibCate=" + exhibCate
				+ ", exhibCateName=" + exhibCateName + ", exhibName=" + exhibName + ", exhibStart=" + exhibStart
				+ ", exhibEnd=" + exhibEnd + ", exhibCon=" + exhibCon + ", exhibCurrent=" + exhibCurrent
				+ ", exhibPage=" + exhibPage + ", exhibImagePath=" + exhibImagePath + "]";
	}
	
	
	
}
