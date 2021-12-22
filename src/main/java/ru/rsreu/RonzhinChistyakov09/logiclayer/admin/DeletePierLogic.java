package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.administrator.TryDeleteBusyPierException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementTypeGetter;

public class DeletePierLogic {

	private final PierDao pierDao;
	private final StatementDao statementDao;
	private final StatementTypeGetter statementTypeGetter;
	private final StatementStatusGetter statementStatusGetter;

	public DeletePierLogic(PierDao pierDao, StatementDao statementDao, StatementTypeDao statementTypeDao,
			StatementStatusDao statementStatusDao) {
		this.pierDao = pierDao;
		this.statementDao = statementDao;
		this.statementTypeGetter = new StatementTypeGetter(statementTypeDao);
		this.statementStatusGetter = new StatementStatusGetter(statementStatusDao);
	}

	public void deletePier(int id) throws DataRequestException, TryDeleteBusyPierException {
		Statement lastStatement = this.statementDao.getLastByPier(id);
		StatementType exitType = this.statementTypeGetter.getExitType();
		StatementStatus finishedStatus = this.statementStatusGetter.getFinishedStatus();
		if (lastStatement == null
				|| lastStatement.getType().equals(exitType) && lastStatement.getStatus().equals(finishedStatus)) {
			this.pierDao.deletePier(id);
		} else {
			throw new TryDeleteBusyPierException(Resourcer.getString("exceptions.captain.delete.busyPier"));
		}
	}

}
