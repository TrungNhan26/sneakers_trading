package Model.Bean;

public class account {
	private int id;
	private String user;
	private String pass;
	private String isSell;
	private String isAdmin;
	
	public account(int id, String user, String pass, String isSell, String isAdmin) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}
	
	public account() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getisSell() {
		return isSell;
	}

	public void setSell(String isSell) {
		this.isSell = isSell;
	}

	public String getisAdmin() {
		return isAdmin;
	}

	public void setAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "account [id=" + id + ", user=" + user + ", pass=" + pass + ", isSell=" + isSell + ", isAdmin=" + isAdmin
				+ "]";
	}

	
	
	
	
	
	
}
