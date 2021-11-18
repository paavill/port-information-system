package ru.rsreu.RonzhinChistyakov09.datalayer.data.statement;

import java.util.Date;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;

public class Statement {
	private int id;
	private User user;
	private Ship ship; 
	private Pier pier; // NULL
	private StatementType type;
	private StatementState state;
	private Date doDate; 
	private Date finishDate; // NULL
	
	
	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Ship getShip() {
		return ship;
	}

	public Pier getPier() {
		return pier;
	}


	public StatementType getType() {
		return type;
	}

	public StatementState getState() {
		return state;
	}

	public Date getDoDate() {
		return doDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}
}
