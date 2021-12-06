package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class LogoutLogic {

	UserDao userDao;

	public LogoutLogic(UserDao userDao) {
		this.userDao = userDao;
	}

	public void logout(User user) throws DataRequestException {
		// если статуса такого не будет, логику удалить
		user.setStatus(new UserStatus(0, "UNATHORIZED"));
		this.userDao.updateUser(user);
	}

}
