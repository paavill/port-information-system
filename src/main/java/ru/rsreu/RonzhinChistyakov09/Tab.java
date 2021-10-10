package ru.rsreu.RonzhinChistyakov09;

import java.util.Collection;

public class Tab {

	private String name;
	private Collection<Port> data;

	public Tab(String name, Collection<Port> data) {
		super();
		this.name = name;
		this.data = data;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Port> getData() {
		return data;
	}

	public void setData(Collection<Port> data) {
		this.data = data;
	}

}
