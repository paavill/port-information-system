package ru.rsreu.RonzhinChistyakov09.datalayer.data.pier;

public class Pier {
	private int id;
	private int capacity;
	private int residual�apacity; 
	private String status;
	
	public Pier(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}
	
	public Pier(int id, int capacity, int residualCapacity, String status) {
		this.id = id;
		this.capacity = capacity;
		this.residual�apacity = residualCapacity;
		this.status = status;
	}
	
	public int getResidual�apacity() {
		return residual�apacity;
	}

	public String getStatus() {
		return status;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		return "Pier [id=" + id + ", capacity=" + capacity + "]";
	}
}