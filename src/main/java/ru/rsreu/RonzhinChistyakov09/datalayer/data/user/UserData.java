package ru.rsreu.RonzhinChistyakov09.datalayer.data.user;

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
	
	@Override
	public String toString() {
		return "UserData [id=" + id + ", role=" + role + ", passportNumber=" + passportNumber + ", fullName=" + fullName
				+ ", age=" + age + "]";
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAge(int age) {
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
