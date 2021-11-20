package ru.rsreu.RonzhinChistyakov09.datalayer.data.statement;

public class StatementType {
	private int id;
	private String title;
	
	public StatementType(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "StatementType [id=" + id + ", title=" + title + "]";
	}
}
