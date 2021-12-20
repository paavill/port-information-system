package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementTypeGetter;

public class CreateStatementLogic {

	private final StatementDao statementDao;
	private final StatementTypeGetter statementTypeGetter;

	public CreateStatementLogic(StatementDao statementDao, StatementTypeDao statementTypeDao) {
		this.statementDao = statementDao;
		this.statementTypeGetter = new StatementTypeGetter(statementTypeDao);
	}

	public void createStatement(Statement statement, User user) throws DataRequestException {
		Statement lastStatement = this.statementDao.getLastByUserId(user.getId());
		this.statementDao.createStatement(statement);
		StatementType exitType = this.statementTypeGetter.getExitType();
		if (statement.getType().equals(exitType)) {
			this.statementDao.updatePier(statement.getId(), lastStatement.getPier().getId());
		}
	}
}
