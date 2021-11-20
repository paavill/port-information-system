package ru.rsreu.RonzhinChistyakov09.datalayer.data.statement;

public class StatementStatus {
	private int id;
	private String title;
	
	public StatementStatus(int id, String title) {
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
		return "StatementStatus [id=" + id + ", title=" + title + "]";
	}
}