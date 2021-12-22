package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import java.sql.Date;
import java.time.LocalDate;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;

public class FinishStatementLogic {

	private final StatementDao statementDao;
	private final StatementStatusGetter statementStatusGetter;

	public FinishStatementLogic(StatementDao statementDao, StatementStatusDao statementStatusDao) {
		this.statementDao = statementDao;
		this.statementStatusGetter = new StatementStatusGetter(statementStatusDao);
	}

	public void finishStatement(int statementId) throws DataRequestException {
		StatementStatus status = this.statementStatusGetter.getFinishedStatus();
		this.statementDao.updateStatus(status, statementId);
		Date date = Date.valueOf(LocalDate.now());
		this.statementDao.updateFinishDate(date, statementId);
	}

}
