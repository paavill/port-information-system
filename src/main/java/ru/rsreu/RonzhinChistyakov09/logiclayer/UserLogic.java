package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class UserLogic {

	UserDao userDao;
	
	public UserLogic(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User getUserById(int id) throws DataRequestException {
		return userDao.getUserById(id);
	}
}
