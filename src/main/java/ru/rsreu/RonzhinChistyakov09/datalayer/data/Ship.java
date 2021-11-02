package ru.rsreu.RonzhinChistyakov09.datalayer.data;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;

public class Ship {
	private int id;
	private User user;
	private String title;
	private int capacity;
	
	public Ship(int id, User user, String title, int capacity) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getTitle() {
		return title;
	}

	public int getCapacity() {
		return capacity;
	}
}
