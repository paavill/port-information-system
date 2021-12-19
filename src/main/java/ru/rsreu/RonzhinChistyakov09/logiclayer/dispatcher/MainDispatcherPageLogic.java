package ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementStatusGetter;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserRoleGetter;

public class MainDispatcherPageLogic {

	private final PierDao pierDao;
	private final UserDao userDao;
	private final UserRoleGetter userRoleGetter;
	private final ShipDao shipDao;
	private final StatementDao statementDao;
	private final StatementStatusGetter statementStatusGetter;

	public MainDispatcherPageLogic(PierDao pierDao, UserDao userDao, ShipDao shipDao, StatementDao statementDao,
			UserRoleDao userRoleDao, StatementStatusDao statementStatusDao) {
		this.pierDao = pierDao;
		this.userDao = userDao;
		this.userRoleGetter = new UserRoleGetter(userRoleDao);
		this.shipDao = shipDao;
		this.statementDao = statementDao;
		this.statementStatusGetter = new StatementStatusGetter(statementStatusDao);
	}

	public Collection<Pier> getPiers() throws DataRequestException {
		return this.pierDao.getAllPiers();
	}

	public Collection<User> getCaptains() throws DataRequestException {
		UserRole role = this.userRoleGetter.getCaptainRole();
		return this.userDao.getUsersByRoleId(role.getId());
	}

	public Collection<Ship> getShips() throws DataRequestException {
		return this.shipDao.getAllShips();
	}

	public Collection<Statement> getStatements() throws DataRequestException {
		StatementStatus status = this.statementStatusGetter.getCreatedStatus();
		return this.statementDao.getStatementsByStatus(status);
	}

}
