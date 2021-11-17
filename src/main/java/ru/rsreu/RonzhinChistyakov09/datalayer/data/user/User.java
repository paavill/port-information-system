package ru.rsreu.RonzhinChistyakov09.datalayer.data.user;

public class User {
	private int id;
	private String login;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", fullName=" + fullName + ", status="
				+ status + ", role=" + role + "]";
	}
}
