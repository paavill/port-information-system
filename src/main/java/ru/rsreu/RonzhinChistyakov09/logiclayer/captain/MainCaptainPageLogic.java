package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementTypeGetter;

public class MainCaptainPageLogic {

	private final StatementDao statementDao;
	private final StatementTypeGetter statementTypeGetter;
	private final StatementStatusGetter statementStatusGetter;

	public MainCaptainPageLogic(StatementDao statementDao, StatementTypeDao statementTypeDao,
			StatementStatusDao statementStatusDao) {
		this.statementDao = statementDao;
		this.statementTypeGetter = new StatementTypeGetter(statementTypeDao);
		this.statementStatusGetter = new StatementStatusGetter(statementStatusDao);
	}

	public Statement getCurrentStatement(int userId) throws DataRequestException {
		Statement statement = this.statementDao.getLastByUserId(userId);
		if (statement == null) {
			return null;
		}
		StatementStatus status = statement.getStatus();
		StatementStatus createdStatus = this.statementStatusGetter.getCreatedStatus();
		StatementStatus approvedStatus = this.statementStatusGetter.getApprovedStatus();
		if (status.equals(createdStatus) || status.equals(approvedStatus)) {
			return statement;
		}
		return null;
	}

	public Collection<Statement> getUserEnterTypeStatement(int userId) throws DataRequestException {
		StatementType type = this.statementTypeGetter.getEnterType();
		return getUserStatementByType(userId, type);
	}

	public Collection<Statement> getUserExitTypeStatement(int userId) throws DataRequestException {
		StatementType type = this.statementTypeGetter.getExitType();
		return getUserStatementByType(userId, type);
	}

	private Collection<Statement> getUserStatementByType(int userId, StatementType type) throws DataRequestException {
		return this.statementDao.getUserStatementsByType(userId, type);
	}

	public Statement getLastStatement(int userId) throws DataRequestException {
		return this.statementDao.getLastByUserId(userId);
	}

	public StatementStatus getCreatedStatement() throws DataRequestException {
		return this.statementStatusGetter.getCreatedStatus();
	}

	public Statement getLastFinishedStatement(int id) throws DataRequestException {
		return this.statementDao.getLastFinishedStatement(id);
	}

	public StatementType getExitType() throws DataRequestException {
		return this.statementTypeGetter.getExitType();
	}
}
