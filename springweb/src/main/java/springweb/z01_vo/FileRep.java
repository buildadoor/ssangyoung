package springweb.z01_vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileRep {
	private int number;
	private String title;
	private String path;
	private String tempfile;
	private String fname;
	private String etc;
	private Date regte;
	private Date uptdate;
	private MultipartFile report;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTempfile() {
		return tempfile;
	}
	public void setTempfile(String tempfile) {
		this.tempfile = tempfile;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public Date getRegte() {
		return regte;
	}
	public void setRegte(Date regte) {
		this.regte = regte;
	}
	public Date getUptdate() {
		return uptdate;
	}
	public void setUptdate(Date uptdate) {
		this.uptdate = uptdate;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
}