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
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementTypeGetter;

public class CreateStatementTransferObject implements DataTransferObject<Statement> {

	private ShipDao shipDao;
	private StatementDao statementDao;
	private final StatementTypeGetter statementTypeGetter;
	private final StatementStatusGetter statementStatusGetter;

	public CreateStatementTransferObject(ShipDao shipDao, StatementDao statementDao,
			StatementStatusDao statementStatusDao, StatementTypeDao statementTypeDao) {
		this.shipDao = shipDao;
		this.statementDao = statementDao;
		this.statementTypeGetter = new StatementTypeGetter(statementTypeDao);
		this.statementStatusGetter = new StatementStatusGetter(statementStatusDao);
	}

	@Override
	public Statement getModel(ServletRequest request) throws DataRequestException {
		User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
		Ship ship = shipDao.getUserShip(user.getId());
		int id = this.statementDao.getCount() + 1;
		Date date = Date.valueOf(LocalDate.now());
		StatementStatus createdStatus = this.statementStatusGetter.getCreatedStatus();
		StatementType type = getStatementTypeNewStatement(user);
		Statement statement = new Statement(id, user, ship, null, type, createdStatus, date, null);
		return statement;
	}

	private StatementType getStatementTypeNewStatement(User user) throws DataRequestException {
		StatementType enterType = this.statementTypeGetter.getEnterType();
		StatementType exitType = this.statementTypeGetter.getExitType();
		Statement lastStatement = this.statementDao.getLastByUserId(user.getId());
		if (lastStatement == null) {
			return enterType;
		}
		StatementStatus rejectedStatus = this.statementStatusGetter.getRejectedStatus();
		StatementStatus canceledStatus = this.statementStatusGetter.getCanceledStatus();
		if (lastStatement.getStatus().equals(rejectedStatus) || lastStatement.getStatus().equals(canceledStatus)) {
			return lastStatement.getType();
		}
		StatementStatus finishedStatus = this.statementStatusGetter.getFinishedStatus();
		if (!lastStatement.getStatus().equals(finishedStatus)) {
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
