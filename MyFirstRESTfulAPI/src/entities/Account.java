package entities;

public class Account {
	private String userName;
	private String password;
	private String role[];
	
	public Account() {
		
	}
	
	public Account(String userName, String password, String[] role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setRole(String[] role) {
		this.role = role;
	}
	
	public String[] getRole() {
		return this.role;
	}
}
