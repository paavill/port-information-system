package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateUserLogic {
	
	private UserDao userDao;
	private UserStatus initUserStatus = new UserStatus(1, "UNATHORIZED");

	public CreateUserLogic(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void createUser(String login, String password, String fullName, UserRole role) throws DataRequestException {
		int newUserId = getNewUserId();
		User user = new User(newUserId, login, password, fullName, initUserStatus, role);
		userDao.createUser(user);
	}
	
	private int getNewUserId() throws DataRequestException {
		return userDao.getLastUserId() + 1;
	}

}
