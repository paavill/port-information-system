package ru.rsreu.RonzhinChistyakov09.datalayer.data.goods;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;

public class Goods {
	private int id;
	private Pier pier;
	private GoodsSpecifications specifications;
	private int count;
	
	public Goods(int id, Pier pier, GoodsSpecifications specifications, int count) {
		super();
		this.id = id;
		this.pier = pier;
		this.specifications = specifications;
		this.count = count;
	}

	public int getId() {
		return id;
	}
	
	public Pier getPier() {
		return pier;
	}
	
	public GoodsSpecifications getSpecifications() {
		return specifications;
	}
	
	public int getCount() {
		return count;
	}
}
