package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.BlockUserException;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.UserNotFoundException;
import ru.rsreu.RonzhinChistyakov09.exceptions.WrongPasswordException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserStatusGetter;

public class LoginLogic {

	private final UserDao userDao;
	private final UserStatusDao userStatusDao;

	public LoginLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusDao = userStatusDao;
	}

	public User login(String login, String password)
			throws DataRequestException, UserNotFoundException, WrongPasswordException, BlockUserException {
		User user = userDao.getUserByLogin(login);
		if (user == null) {
			throw new UserNotFoundException();
		}
		if (checkPassword(user, password)) {
			throw new WrongPasswordException();
		}
		UserStatusGetter getter = new UserStatusGetter(userStatusDao);
		UserStatus blockStatus = getter.getBlockStatus();
		if (user.getStatus().equals(blockStatus)) {
			throw new BlockUserException();
		}
		UserStatus onlineStatus = getter.getOnlineStatus();
		user.setStatus(onlineStatus);
		this.userDao.updateUser(user);
		return user;
	}

	private boolean checkPassword(User user, String password) {
		return !user.getPassword().equals(password);
	}
}
