package ru.rsreu.RonzhinChistyakov09.datalayer.data.product;

/***
 * Data class representing product.
 * @author pavel
 *
 */
public class Product {
	/**
	 * Product title.
	 */
	private String title;
	
	/**
	 * Pier id in which the product is located
	 */
	private int pierId;
	
	/**
	 * Product count
	 */
	private int count;
	
	public Product(String title, int pierId, int count) {
		this.title = title;
		this.pierId = pierId;
		this.count = count;
	}

	public final int getCount() {
		return count;
	}

	public final void setCount(int count) {
		this.count = count;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final int getPierId() {
		return pierId;
	}

	public final void setPierId(int pierId) {
		this.pierId = pierId;
	}
	
	@Override
	public String toString() {
		return "Product [title=" + title + ", pier=" + pierId + ", count=" + count + "]";
	}

}
