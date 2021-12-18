package ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class RejectStatementLogic {

	private final StatementDao statementDao;
	private final StatementStatusDao statementStatusDao;
	private final static String REJECT_STATEMENT_TITLE = "REJECTED";

	public RejectStatementLogic(StatementDao statementDao, StatementStatusDao statementStatusDao) {
		this.statementDao = statementDao;
		this.statementStatusDao = statementStatusDao;
	}

	public void rejectStatement(int statementId) throws DataRequestException {
		StatementStatus status = this.statementStatusDao.getByTitle(REJECT_STATEMENT_TITLE);
		Statement statement = this.statementDao.getById(statementId);
		statement.setStatus(status);
		this.statementDao.update(statement);
	}

}
