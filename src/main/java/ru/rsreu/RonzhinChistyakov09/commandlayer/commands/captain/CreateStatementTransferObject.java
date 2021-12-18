package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.DataTransferObject;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateStatementTransferObject implements DataTransferObject<Statement> {

	private ShipDao shipDao;
	private StatementDao statementDao;
	private StatementStatusDao statementStatusDao;
	private StatementTypeDao statementTypeDao;
	private static final String FINISH_STATUS_TITLE = "FINISHED";
	private static final String CREATE_STATUS_TITLE = "CREATED";
	private static final String ENTER_TYPE_TITLE = "ENTER";
	private static final String EXIT_TYPE_TITLE = "EXIT";

	public CreateStatementTransferObject(ShipDao shipDao, StatementDao statementDao,
			StatementStatusDao statementStatusDao, StatementTypeDao statementTypeDao) {
		this.shipDao = shipDao;
		this.statementDao = statementDao;
		this.statementStatusDao = statementStatusDao;
		this.statementTypeDao = statementTypeDao;
	}

	@Override
	public Statement getModel(ServletRequest request) throws DataRequestException {
		User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
		Ship ship = shipDao.getUserShip(user.getId());
		int id = this.statementDao.getCount() + 1;
		Date date = Date.valueOf(LocalDate.now());
		StatementStatus createStatus = this.statementStatusDao.getByTitle(CREATE_STATUS_TITLE);
		StatementType type = getStatementTypeNewStatement(user);
		Statement statement = new Statement(id, user, ship, null, type, createStatus, date, null);
		return statement;
	}

	private StatementType getStatementTypeNewStatement(User user) throws DataRequestException {
		StatementType enterType = this.statementTypeDao.getByTitle(ENTER_TYPE_TITLE);
		StatementType exitType = this.statementTypeDao.getByTitle(EXIT_TYPE_TITLE);
		Statement lastStatement = this.statementDao.getLastByUserId(user.getId());
		if(lastStatement == null) {
			return enterType;
		}
		StatementStatus finishStatus = this.statementStatusDao.getByTitle(FINISH_STATUS_TITLE);
		if (!lastStatement.getStatus().equals(finishStatus)) {
			throw new DataRequestException("STATEMENT NOT FINISHED");
		}
		if (lastStatement.getType().equals(enterType)) {
			return exitType;
		}
		if (lastStatement.getType().equals(exitType)) {
			return enterType;
		}
		throw new DataRequestException("bad type");
	}

}
