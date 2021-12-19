package ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class ProcessStatementPageLogic {

	private final PierDao pierDao;
	private final StatementDao statemntDao;

	public ProcessStatementPageLogic(StatementDao statemntDao, PierDao pierDao) {
		this.pierDao = pierDao;
		this.statemntDao = statemntDao;
	}

	public Statement getStatementById(int id) throws DataRequestException {
		return this.statemntDao.getById(id);
	}

	public Collection<Pier> getFreePiers() throws DataRequestException {
		return this.pierDao.getFreePiers();
	}
}
