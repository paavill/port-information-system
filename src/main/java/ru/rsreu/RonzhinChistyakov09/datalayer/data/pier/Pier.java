package ru.rsreu.RonzhinChistyakov09.datalayer.data.pier;

public class Pier {
	private int id;
	private int capacity;
	private int residual�apacity; 
	
	public Pier(int id, int capacity, int residual�apacity) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.residual�apacity = residual�apacity;
	}

	public int getResidual�apacity() {
		return residual�apacity;
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
		return "Pier [id=" + id + ", capacity=" + capacity + ", residual�apacity=" + residual�apacity + "]";
	}
}