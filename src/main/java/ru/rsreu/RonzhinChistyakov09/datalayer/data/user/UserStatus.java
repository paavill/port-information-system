package ru.rsreu.RonzhinChistyakov09.datalayer.data.user;

public class UserStatus {
	private int id;
	private String title;
	
	public UserStatus(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "UserStatus [id=" + id + ", title=" + title + "]";
	}
}