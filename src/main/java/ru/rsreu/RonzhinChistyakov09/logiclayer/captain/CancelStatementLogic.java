package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;

public class CancelStatementLogic {

	private final StatementDao statementDao;
	private final StatementStatusGetter statementStatusGetter;

	public CancelStatementLogic(StatementDao statementDao, StatementStatusDao statementStatusDao) {
		this.statementDao = statementDao;
		this.statementStatusGetter = new StatementStatusGetter(statementStatusDao);
	}

	public void cancelStatement(int statementId) throws DataRequestException {
		StatementStatus status = this.statementStatusGetter.getCanseledStatus();
		this.statementDao.updateStatus(status, statementId);
	}

}
