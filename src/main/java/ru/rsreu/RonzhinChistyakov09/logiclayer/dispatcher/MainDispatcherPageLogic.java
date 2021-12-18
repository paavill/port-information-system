package ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class MainDispatcherPageLogic {
	
	private final PierDao pierDao;
	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	private final ShipDao shipDao;
	private final StatementDao statementDao;
	private static final String CAPTAIN_TITLE = "CAPTAIN";
	
	public MainDispatcherPageLogic(PierDao pierDao, UserDao userDao, ShipDao shipDao, StatementDao statementDao, UserRoleDao userRoleDao) {
		this.pierDao = pierDao;
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
		this.shipDao = shipDao;
		this.statementDao = statementDao;
	}
	
	public Collection<Pier> getPiers() throws DataRequestException {
		return this.pierDao.getAllPiers();
	}
	
	public Collection<User> getCaptains() throws DataRequestException{
		UserRole role = this.userRoleDao.getUserRoleByTitle(CAPTAIN_TITLE);
		return this.userDao.getUsersByRoleId(role.getId());
	}
	
	public Collection<Ship> getShips() throws DataRequestException{
		return this.shipDao.getAllShips();
	}
	
	public Collection<Statement> getStatements() throws DataRequestException{
		return this.statementDao.getAllStatements();
	}

}
