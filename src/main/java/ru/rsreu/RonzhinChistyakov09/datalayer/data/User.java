package ru.rsreu.RonzhinChistyakov09.datalayer.data;

public class User {

	/**
	 * Unique individual user number.
	 */
	private final int userId;
	/**
	 * Unique individual port number in which
	 * the user is working.
	 */
	private final int userPortId;
	
	private final int userDataId;
	
	private final String userLogin;
	
	private final String userPassword;
	
	private final String userStatus;
	
	public User(int userId, int userPortId, int userDataId, String userLogin, String userPassword, String userStatus) {
		super();
		this.userId = userId;
		this.userPortId = userPortId;
		this.userDataId = userDataId;
		this.userLogin = userLogin;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
	}

	public final int getUserId() {
		return userId;
	}

	public final int getUserPortId() {
		return userPortId;
	}

	public final int getUserDataId() {
		return userDataId;
	}

	public final String getUserLogin() {
		return userLogin;
	}

	public final String getUserPassword() {
		return userPassword;
	}

	public final String getUserStatus() {
		return userStatus;
	}
	
}
