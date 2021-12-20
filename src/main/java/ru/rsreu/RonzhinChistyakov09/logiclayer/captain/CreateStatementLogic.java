package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateStatementLogic {

	StatementDao statementDao;

	public CreateStatementLogic(StatementDao statementDao) {
		this.statementDao = statementDao;
	}

	public void createStatement(Statement statement, User user) throws DataRequestException {
		Statement lastStatement = this.statementDao.getLastByUserId(user.getId());
		this.statementDao.createStatement(statement);
		if (statement.getType().getId() == 1) {
			this.statementDao.updatePier(statement.getId(), lastStatement.getPier().getId());
		}
	}
}
