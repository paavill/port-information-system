package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class EditUserPageLogic {

	private UserDao userDao;
	private UserRoleDao userRoleDao;

	public EditUserPageLogic(UserDao userDao, UserRoleDao userRoleDao) {
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
	}

	public Collection<UserRole> getUserRoles() throws DataRequestException {
		return this.userRoleDao.getUserRoles();
	}

	public User getUserById(int id) throws DataRequestException {
		return this.userDao.getUserById(id);
	}

}
