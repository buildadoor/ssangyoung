package jspexp.vo;

public class Tuition {
	private String id;
	private String fileName;
	private String filePath;
	public Tuition() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Tuition(String fileName) {
		this.fileName = fileName;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
