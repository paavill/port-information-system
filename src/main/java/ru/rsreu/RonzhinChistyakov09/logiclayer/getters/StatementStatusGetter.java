package ru.rsreu.RonzhinChistyakov09.logiclayer.getters;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class StatementStatusGetter {

	private final String CREATED_STATUS_TITLE = Resourcer.getString("database.statements.statuses.created");
	private final String APPROVED_STATUS_TITLE = Resourcer.getString("database.statements.statuses.approved");;
	private final String REJECTED_STATUS_TITLE = Resourcer.getString("database.statements.statuses.rejected");;
	private final String FINISHED_STATUS_TITLE = Resourcer.getString("database.statements.statuses.finished");;

	private final StatementStatusDao dao;

	public StatementStatusGetter(StatementStatusDao dao) {
		this.dao = dao;
	}

	public StatementStatus getCreatedStatus() throws DataRequestException {
		return this.dao.getByTitle(CREATED_STATUS_TITLE);
	}

	public StatementStatus getApprovedStatus() throws DataRequestException {
		return this.dao.getByTitle(APPROVED_STATUS_TITLE);
	}

	public StatementStatus getRejectedStatus() throws DataRequestException {
		return this.dao.getByTitle(REJECTED_STATUS_TITLE);
	}

	public StatementStatus getFinishedStatus() throws DataRequestException {
		return this.dao.getByTitle(FINISHED_STATUS_TITLE);
	}

}
