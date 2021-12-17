package ru.rsreu.RonzhinChistyakov09.datalayer.data.statement;

import java.util.Date;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;

public class Statement {
	private int id;
	private User user;
	private Ship ship; 
	private Pier pier;
	private StatementType type;
	private StatementStatus status;
	private Date doDate; 
	private Date finishDate;
	
	public Statement(int id, User user, Ship ship, Pier pier, StatementType type, StatementStatus state, Date doDate,
			Date finishDate) {
		super();
		this.id = id;
		this.user = user;
		this.ship = ship;
		this.pier = pier;
		this.type = type;
		this.status = state;
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

	public StatementType getType() {
		return type;
	}

	public StatementStatus getStatus() {
		return status;
	}

	public Date getDoDate() {
		return doDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}
	
	@Override
	public String toString() {
		return "Statement [id=" + id + ", user=" + user + ", ship=" + ship + ", pier=" + pier + ", type=" + type
				+ ", state=" + status + ", doDate=" + doDate + ", finishDate=" + finishDate + "]";
	}
}
