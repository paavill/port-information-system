package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.UserNotFoundException;
import ru.rsreu.RonzhinChistyakov09.exceptions.WrongPasswordException;

public class LoginLogic {
	UserDao userDao;

	public LoginLogic(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(String login, String password)
			throws DataRequestException, UserNotFoundException, WrongPasswordException {
		User user = userDao.getByLogin(login);
		if (user == null) {
			throw new UserNotFoundException();
		}
		if (checkPassword(user, password)) {
			throw new WrongPasswordException();
		}
		user.setStatus(new UserStatus(0, "AUTHORIZED"));
		userDao.updateUser(user.getId(), user);
		return user;
	}
	
	private boolean checkPassword(User user, String password) {
		return !user.getPassword().equals(password);
	}
}
