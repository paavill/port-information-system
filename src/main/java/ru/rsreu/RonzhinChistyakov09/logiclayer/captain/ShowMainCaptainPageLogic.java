package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class ShowMainCaptainPageLogic {

	private final StatementDao statementDao;
	private final StatementTypeDao statementTypeDao;
	private final StatementStatusDao statementStatusDao;
	private static final String ENTER_TYPE_TITLE = "ENTER";
	private static final String EXIT_TYPE_TITLE = "EXIT";
	private static final String FINISH_STATUS_TITLE = "FINISHED";
	
	
	public ShowMainCaptainPageLogic(StatementDao statementDao, StatementTypeDao statementTypeDao, StatementStatusDao statementStatusDao) {
		this.statementDao = statementDao;
		this.statementTypeDao = statementTypeDao;
		this.statementStatusDao = statementStatusDao;
		
	}
	
	public Collection<Statement> getUserEnterTypeStatement(int userId) throws DataRequestException{
		StatementType type = this.statementTypeDao.getByTitle(ENTER_TYPE_TITLE);
		return getUserStatementByType(userId, type);
	}

	
	public Collection<Statement> getUserExitTypeStatement(int userId) throws DataRequestException{
		StatementType type = this.statementTypeDao.getByTitle(EXIT_TYPE_TITLE);
		return getUserStatementByType(userId, type);
	}
	
	private Collection<Statement> getUserStatementByType(int userId, StatementType type) throws DataRequestException{
		StatementStatus status = this.statementStatusDao.getByTitle(FINISH_STATUS_TITLE);
		return this.statementDao.getUserStatementsByType(userId, type, status);
	}
}
