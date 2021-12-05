package ru.rsreu.RonzhinChistyakov09.logiclayer;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class MainAdminPageLogic {

	private PierDao pierDao;
	private UserDao userDao;
	
	public MainAdminPageLogic(PierDao pierDao, UserDao userDao) {
		this.pierDao = pierDao;
		this.userDao = userDao;
	}
	
	public Collection<Pier> getPiers() throws DataRequestException {
		return pierDao.getAllPiers();
	}
	
	public Collection<User> getUsers() throws DataRequestException{
		return userDao.getAllUsers();
	}
}
