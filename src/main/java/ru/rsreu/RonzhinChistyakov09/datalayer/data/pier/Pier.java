package ru.rsreu.RonzhinChistyakov09.datalayer.data.pier;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.goods.Goods;

public class Pier {
	private int id;
	private PierStatus status;
	private int capacity;
	private Collection<Goods> goods;
	private int residualÑapacity; // Ìá ñ÷èòàòü âìåñòèìîñòü ïî ìàññèâó òîâàğîâ, à íå õğàíèòü îòäåëüíîå ïîëå
	
	public Pier(int id, PierStatus status, int capacity, Collection<Goods> goods, int residualÑapacity) {
		super();
		this.id = id;
		this.status = status;
		this.capacity = capacity;
		this.goods = goods;
		this.residualÑapacity = residualÑapacity;
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
