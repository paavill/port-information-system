package ru.rsreu.RonzhinChistyakov09.datalayer.data;

public class Ship {
	private int id;
	private String title;
	
	public Ship(int id, String title) {
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
		return "Ship [id=" + id + ", title=" + title + ", capacity=" + "]";
	}

}
