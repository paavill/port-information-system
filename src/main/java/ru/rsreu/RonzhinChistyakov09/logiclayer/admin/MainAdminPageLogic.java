package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class MainAdminPageLogic {

	private PierDao pierDao;
	private UserDao userDao;
	private ShipDao shipDao;
	
	public MainAdminPageLogic(PierDao pierDao, UserDao userDao, ShipDao shipDao) {
		this.pierDao = pierDao;
		this.userDao = userDao;
		this.shipDao = shipDao;
	}
	
	public Collection<Pier> getPiers() throws DataRequestException {
		return pierDao.getAllPiers();
	}
	
	public Collection<User> getUsers() throws DataRequestException{
		return userDao.getAllUsers();
	}
	
	public Collection<Ship> getShips() throws DataRequestException{
		return shipDao.getAllShips();
	}
}
