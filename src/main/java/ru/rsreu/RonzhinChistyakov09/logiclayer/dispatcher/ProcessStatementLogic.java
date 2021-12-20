package ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementTypeGetter;

public class ProcessStatementLogic {

	private final StatementDao statementDao;
	private final StatementTypeGetter statementTypeGetter;

	public ProcessStatementLogic(StatementDao statementDao, StatementTypeDao statementTypeDao) {
		this.statementDao = statementDao;
		this.statementTypeGetter = new StatementTypeGetter(statementTypeDao);
	}

	public StatementType getStatementType(int statementId) throws DataRequestException {
		return this.statementDao.getById(statementId).getType();
	}

}
