package ru.rsreu.RonzhinChistyakov09.datalayer.data.statement;

public class StatementState {
	private int id;
	private String title;
	
	public StatementState(int id, String title) {
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
}