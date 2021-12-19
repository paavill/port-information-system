package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class MainCaptainPageLogic {

	private final StatementDao statementDao;
	private final StatementTypeDao statementTypeDao;
	private final StatementStatusDao statementStatusDao;
	private static final String ENTER_TYPE_TITLE = "ENTER";
	private static final String EXIT_TYPE_TITLE = "EXIT";
	private static final String FINISH_STATUS_TITLE = "FINISHED";
	private static final String REJECT_STATUS_TITLE = "REJECTED";

	public MainCaptainPageLogic(StatementDao statementDao, StatementTypeDao statementTypeDao,
			StatementStatusDao statementStatusDao) {
		this.statementDao = statementDao;
		this.statementTypeDao = statementTypeDao;
		this.statementStatusDao = statementStatusDao;

	}

	public Statement getCurrentStatement(int userId) throws DataRequestException {
		Statement statement = this.statementDao.getLastByUserId(userId);
		if (statement == null) {
			return null;
		}
		StatementStatus finishStatus = this.statementStatusDao.getByTitle(FINISH_STATUS_TITLE);
		StatementStatus rejectStatus = this.statementStatusDao.getByTitle(REJECT_STATUS_TITLE);
		if (statement.getStatus().equals(finishStatus)) {
			return null;
		}
		if (statement.getStatus().equals(rejectStatus)) {
			return null;
		}
		return statement;
	}

	public Collection<Statement> getUserEnterTypeStatement(int userId) throws DataRequestException {
		StatementType type = this.statementTypeDao.getByTitle(ENTER_TYPE_TITLE);
		return getUserStatementByType(userId, type);
	}

	public Collection<Statement> getUserExitTypeStatement(int userId) throws DataRequestException {
		StatementType type = this.statementTypeDao.getByTitle(EXIT_TYPE_TITLE);
		return getUserStatementByType(userId, type);
	}

	private Collection<Statement> getUserStatementByType(int userId, StatementType type) throws DataRequestException {
		StatementStatus finishStatus = this.statementStatusDao.getByTitle(FINISH_STATUS_TITLE);
		StatementStatus rejectStatus = this.statementStatusDao.getByTitle(REJECT_STATUS_TITLE);
		Collection<Statement> result = this.statementDao.getUserStatementsByType(userId, type, finishStatus);
		Collection<Statement> rejectsStatement = this.statementDao.getUserStatementsByType(userId, type, rejectStatus);
		result.addAll(rejectsStatement);
		return result;
	}
}
