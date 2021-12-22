package ru.rsreu.RonzhinChistyakov09.datalayer.data.user;

/***
 * Data class representing user.
 * @author pavel
 *
 */
public class User {
	
	/**
	 * Unique user identifier.
	 */
	private int id;
	
	/**
	 * User login
	 */
	private String login;
	
	/**
	 * User passwqord
	 */
	private String password;
	private String fullName;
	private UserStatus status;
	private UserRole role;

	public User(int id, String login, String password, String fullName, UserStatus status, UserRole role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fullName;
	}

	public UserStatus getStatus() {
		return status;
	}

	public UserRole getRole() {
		return role;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", fullName=" + fullName + ", status="
				+ status + ", role=" + role + "]";
	}
}
