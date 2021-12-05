package ru.rsreu.RonzhinChistyakov09.logiclayer;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class UserRoleLogic {

	UserDao userDao;

	public UserRoleLogic(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserRole getUserRoleByTitle(String title) throws DataRequestException {
		return userDao.getUserRoleByTitle(title);
	}

	public Collection<UserRole> getUserRoles() throws DataRequestException {
		return userDao.getUserRoles();
	}
}
