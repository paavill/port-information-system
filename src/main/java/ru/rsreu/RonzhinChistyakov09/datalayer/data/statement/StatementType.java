package ru.rsreu.RonzhinChistyakov09.datalayer.data.statement;

import java.util.Objects;

public class StatementType {

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatementType other = (StatementType) obj;
		return id == other.id && Objects.equals(title, other.title);
	}

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
