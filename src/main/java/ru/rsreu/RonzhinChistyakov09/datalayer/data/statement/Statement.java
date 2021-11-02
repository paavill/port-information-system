package ru.rsreu.RonzhinChistyakov09.datalayer.data.statement;

import java.util.Date;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pilot.Pilot;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;

public class Statement {
	private int id;
	private User user;
	private Ship ship; 
	private Pier pier; // NULL
	private Pilot pilot; // NULL
	private StatementType type;
	private StatementState state;
	private Date doDate; 
	private Date finishDate; // NULL
	
	public Statement(int id, User user, Ship ship, Pier pier, Pilot pilot, StatementType type, StatementState state,
			Date doDate, Date finishDate) {
		super();
		this.id = id;
		this.user = user;
		this.ship = ship;
		this.pier = pier;
		this.pilot = pilot;
		this.type = type;
		this.state = state;
		this.doDate = doDate;
		this.finishDate = finishDate;
	}
	
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

	public Pilot getPilot() {
		return pilot;
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
