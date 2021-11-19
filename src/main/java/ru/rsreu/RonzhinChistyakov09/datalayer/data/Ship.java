package ru.rsreu.RonzhinChistyakov09.datalayer.data;

public class Ship {
	private int id;
	private String title;
	private int capacity;
	
	public Ship(int id, String title, int capacity) {
		super();
		this.id = id;
		this.title = title;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return "Ship [id=" + id + ", title=" + title + ", capacity=" + capacity + "]";
	}

}
