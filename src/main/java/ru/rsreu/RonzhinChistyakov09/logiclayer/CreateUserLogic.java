package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateUserLogic {

	private UserDao userDao;
	private UserRoleLogic userRoleLogic;
	// Отсюда брать статус неавторизованного
	private UserStatusLogic userStatusLogic;
	private static UserStatus INIT_USER_STATUS = new UserStatus(1, "UNATHORIZED");

	public CreateUserLogic(UserDao userDao) {
		this.userDao = userDao;
		this.userRoleLogic = new UserRoleLogic(this.userDao);
		this.userStatusLogic = new UserStatusLogic();
	}

	public void createUser(String login, String password, String fullName, String roleTitle)
			throws DataRequestException {
		int newUserId = getNewUserId();
		UserRole userRole = this.userRoleLogic.getUserRoleByTitle(roleTitle);
		User user = new User(newUserId, login, password, fullName, INIT_USER_STATUS, userRole);
		userDao.createUser(user);
	}

	private int getNewUserId() throws DataRequestException {
		return userDao.getLastUserId() + 1;
	}
}
