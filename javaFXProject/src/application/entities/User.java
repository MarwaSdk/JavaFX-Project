package application.entities;

public class User {
	
	private String username;
	private String password;
	private String email;
	private String telephone;
	
	public User(String email,String password) {
		this.email = email;
		this.password = password;
	}
	public User(String username, String password, String email, String telephone) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", telephone=" + telephone
				+ "]";
	}
	
	
	

}
