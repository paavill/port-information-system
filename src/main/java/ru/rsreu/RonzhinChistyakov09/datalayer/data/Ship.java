package ru.rsreu.RonzhinChistyakov09.datalayer.data;


/***
 * Data class representing Ship.
 * @author pavel
 *
 */
public class Ship {
	/**
	 * Unique identifier of the ship
	 */
	private int id;
	
	/**
	 * Name of the ship
	 */
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
		return "Ship [id=" + id + ", title=" + title + "]";
	}

}
