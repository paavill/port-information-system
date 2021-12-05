package ru.rsreu.RonzhinChistyakov09.logiclayer;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class EditUserPageLogic {

	private UserRoleLogic userRoleLogic;
	private UserLogic userLogic;

	public EditUserPageLogic(UserDao userDao) {
		this.userRoleLogic = new UserRoleLogic(userDao);
		this.userLogic = new UserLogic(userDao);
	}

	public Collection<UserRole> getUserRoles() throws DataRequestException {
		return this.userRoleLogic.getUserRoles();
	}

	public User getUserById(int id) throws DataRequestException {
		return this.userLogic.getUserById(id);
	}

}
