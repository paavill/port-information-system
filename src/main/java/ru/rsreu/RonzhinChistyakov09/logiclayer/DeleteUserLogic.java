package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class DeleteUserLogic {

	UserDao userDao;
	
	public DeleteUserLogic(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void deleteUser(int id) throws DataRequestException {
		this.userDao.deleteUser(id);
	}

}
