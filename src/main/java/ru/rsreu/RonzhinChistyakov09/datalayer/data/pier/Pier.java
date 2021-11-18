package ru.rsreu.RonzhinChistyakov09.datalayer.data.pier;

public class Pier {
	private int id;
	private int capacity;
	private int residualÑapacity; 
	
	public Pier(int id, int capacity, int residualÑapacity) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.residualÑapacity = residualÑapacity;
	}

	public int getResidualÑapacity() {
		return residualÑapacity;
	}

	public Pier(int id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		return "Pier [id=" + id + ", capacity=" + capacity + ", residualÑapacity=" + residualÑapacity + "]";
	}
}