package ru.rsreu.RonzhinChistyakov09.datalayer.data.user;

public class User {
	private int id;
	private UserData data;
	private String login;
	private String password;
	private UserStatus status;
	
	public User(int id, UserData data, String login, String password, UserStatus status) {
		super();
		this.id = id;
		this.data = data;
		this.login = login;
		this.password = password;
		this.status = status;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserStatus getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	public UserData getData() {
		return data;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
	public void setStatus(UserStatus status) {
		this.status = status;
	}
}
