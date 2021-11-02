package ru.rsreu.RonzhinChistyakov09.datalayer.data.pier;

public class Pier {
	private int id;
	private PierStatus status;
	private int capacity;
	
	public Pier(int id, PierStatus status, int capacity) {
		super();
		this.id = id;
		this.status = status;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}
	
	public PierStatus getStatus() {
		return status;
	}
	
	public int getCapacity() {
		return capacity;
	}
}
