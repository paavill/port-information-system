package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class EditUserLogic {
	
	UserDao userDao;
	
	public EditUserLogic(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void editUser(int id, User user) throws DataRequestException {
		this.userDao.updateUser(id, user);
	}
}
