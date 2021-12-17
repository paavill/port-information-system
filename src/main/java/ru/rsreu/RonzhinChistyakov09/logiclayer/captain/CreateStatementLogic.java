package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateStatementLogic {
	
	StatementDao statementDao;

	public CreateStatementLogic(StatementDao statementDao) {
		this.statementDao = statementDao;
	}

	public void createStatement(Statement statement) throws DataRequestException {
		this.statementDao.createStatement(statement);
	}
	
}
