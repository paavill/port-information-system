package ru.rsreu.RonzhinChistyakov09.datalayer.data.user;

public class UserRole {
	private int id;
	private String title;
	
	public UserRole(int id, String title) {
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
		return "UserRole [id=" + id + ", title=" + title + "]";
	}
}
