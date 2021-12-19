package ru.rsreu.RonzhinChistyakov09.datalayer.data.user;

import java.util.Objects;

public class UserRole {
	private int id;
	private String title;

	public UserRole(int id, String title) {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return id == other.id && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", title=" + title + "]";
	}
}
