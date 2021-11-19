package ru.rsreu.RonzhinChistyakov09.datalayer.data.goods;

public class Goods {
	private int id;
	private GoodsSpecifications specifications;
	private int count;
	
	public Goods(int id, GoodsSpecifications specifications, int count) {
		super();
		this.id = id;
		this.specifications = specifications;
		this.count = count;
	}

	public int getId() {
		return id;
	}
	
	public GoodsSpecifications getSpecifications() {
		return specifications;
	}
	
	public int getCount() {
		return count;
	}
}
