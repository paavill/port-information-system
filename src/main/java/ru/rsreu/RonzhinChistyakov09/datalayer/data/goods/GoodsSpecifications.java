package ru.rsreu.RonzhinChistyakov09.datalayer.data.goods;

public class GoodsSpecifications {
	private int id;
	private String manufacturer;
	private String name;
	private String country;
	private String units;
	
	public GoodsSpecifications(int id, String manufacturer, String name, String country, String units) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.name = name;
		this.country = country;
		this.units = units;
	}

	public int getId() {
		return id;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getUnits() {
		return units;
	}
}
