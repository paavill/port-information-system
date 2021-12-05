package ru.rsreu.RonzhinChistyakov09.logiclayer;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateUserPageLogic {
	
	UserDao userDao;
	private UserRoleLogic userRoleLogic;

	public CreateUserPageLogic(UserDao userDao) {
		this.userDao = userDao;
		this.userRoleLogic = new UserRoleLogic(userDao);
	}

	public Collection<UserRole> getUserRoles() throws DataRequestException {
		return userRoleLogic.getUserRoles();
	}
}
