package ksmart42.khtour.dto;

public class FileDto {

	private String fileIdx;
	private String fileOriginalName;
	private String fileNewName;
	private String filePath;
	private Long fileSize;
	public String getFileIdx() {
		return fileIdx;
	}
	public void setFileIdx(String fileIdx) {
		this.fileIdx = fileIdx;
	}
	public String getFileOriginalName() {
		return fileOriginalName;
	}
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}
	public String getFileNewName() {
		return fileNewName;
	}
	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	public Long getFileSize() {
		return fileSize;
	}
	@Override
	public String toString() {
		return "BoardFileDto [fileIdx=" + fileIdx + ", fileOriginalName=" + fileOriginalName + ", fileNewName="
				+ fileNewName + ", filePath=" + filePath + ", fileSize=" + fileSize + "]";
	}
	
	
}
