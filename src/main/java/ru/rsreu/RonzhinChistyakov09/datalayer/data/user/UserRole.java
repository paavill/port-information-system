package ru.rsreu.RonzhinChistyakov09.datalayer.data.user;

public enum UserRole {
	ADMINISTRATOR(0),
	DISPATCHER(1),
	CAPTAIN(2),
	NONE(3);
	private int id;
	
	UserRole(int id) {
		this.id = id;
	}
	
	public static UserRole getById(int id) {
		for (UserRole role: values()) {
			if(role.id == id) return role;
		}
		return UserRole.NONE;
	}
}
