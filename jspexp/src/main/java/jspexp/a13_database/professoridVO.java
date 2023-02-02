package jspexp.a13_database;

public class professoridVO {

	private String id;
	private int majorno;
	private String proname;
	private String proemail;
	private String prophone;
	
	public professoridVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public professoridVO(String id, int majorno, String proname, String proemail, String prophone) {
		this.id = id;
		this.majorno = majorno;
		this.proname = proname;
		this.proemail = proemail;
		this.prophone = prophone;
	}

	public professoridVO(String id, String proname) {
		this.id = id;
		this.proname = proname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMajorno() {
		return majorno;
	}

	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProemail() {
		return proemail;
	}

	public void setProemail(String proemail) {
		this.proemail = proemail;
	}

	public String getProphone() {
		return prophone;
	}

	public void setProphone(String prophone) {
		this.prophone = prophone;
	}



	
}


