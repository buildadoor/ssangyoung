package z02_project.vo;

public class Libraries {
	private String local;
	private String libraryname;
	public Libraries() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Libraries(String local) {
		this.local = local;
	}

	public Libraries(String local, String libraryname) {
		this.local = local;
		this.libraryname = libraryname;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLibraryname() {
		return libraryname;
	}
	public void setLibraryname(String libraryname) {
		this.libraryname = libraryname;
	}
	
}