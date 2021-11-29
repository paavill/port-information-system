package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;

public class LoginLogic {
	UserDao userDao;

	public LoginLogic(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(String login, String password) throws Exception {
		User user = userDao.getByLogin(login);
		if (user == null) {
			throw new Exception("user null");
		}
		if (!user.getPassword().trim().equals(password)) {
			throw new Exception("password bad");
		}
		user.setStatus(new UserStatus(0, "AUTHORIZED"));
		userDao.updateUser(user.getId(), user);
		return user;
	}
}
