package ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;

public class RejectStatementLogic {

	private final StatementDao statementDao;
	private final StatementStatusGetter statementStatusGetter;

	public RejectStatementLogic(StatementDao statementDao, StatementStatusDao statementStatusDao) {
		this.statementDao = statementDao;
		this.statementStatusGetter = new StatementStatusGetter(statementStatusDao);
	}

	public void rejectStatement(int statementId) throws DataRequestException {
		StatementStatus status = this.statementStatusGetter.getRejectedStatus();
		this.statementDao.updateStatus(status, statementId);
	}

}
