package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class EditUserLogic {

	UserDao userDao;
	private UserRoleLogic userRoleLogic;
	private UserLogic userLogic;

	public EditUserLogic(UserDao userDao) {
		this.userDao = userDao;
		this.userRoleLogic = new UserRoleLogic(this.userDao);
		this.userLogic = new UserLogic(userDao);
	}

	public void editUser(int userId, String login, String password, String fullName, String statusTitle,
			String roleTitle) throws DataRequestException {
		User user = this.userLogic.getUserById(userId);
		user.setLogin(login);
		user.setPassword(password);
		user.setFullName(fullName);
		UserRole userRole = this.userRoleLogic.getUserRoleByTitle(roleTitle);
		user.setRole(userRole);

		this.userDao.updateUser(user);
	}
}
