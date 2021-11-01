package ru.rsreu.RonzhinChistyakov09.datalayer.data;

public class UserData {
	private int id;
	private UserRole role;
	private String passportNumber;
	private String fullName;
	private int age;
	
	public UserData(int id, UserRole role, String passportNumber, String fullName, int age) {
		super();
		this.id = id;
		this.role = role;
		this.passportNumber = passportNumber;
		this.fullName = fullName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public UserRole getRole() {
		return role;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public int getAge() {
		return age;
	}
}
