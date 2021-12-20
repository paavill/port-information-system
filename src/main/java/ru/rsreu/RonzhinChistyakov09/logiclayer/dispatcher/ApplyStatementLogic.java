package ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;

public class ApplyStatementLogic {

	private final StatementDao statementDao;
	private final StatementStatusGetter statementStatusGetter;

	public ApplyStatementLogic(StatementDao statementDao, StatementStatusDao statementStatusDao) {
		this.statementDao = statementDao;
		this.statementStatusGetter = new StatementStatusGetter(statementStatusDao);
	}

	public StatementType getStatementType(int statementId) throws DataRequestException {
		return this.statementDao.getById(statementId).getType();
	}

	public void applyStatement(int statementId, int pierId) throws DataRequestException {
		this.statementDao.updatePier(statementId, pierId);
		applyStatement(statementId);
	}

	public void applyStatement(int statementId) throws DataRequestException {
		StatementStatus status = this.statementStatusGetter.getApprovedStatus();
		this.statementDao.updateStatus(status, statementId);
	}
}
