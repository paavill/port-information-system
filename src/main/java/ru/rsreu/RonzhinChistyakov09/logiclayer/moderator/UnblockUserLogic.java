package ru.rsreu.RonzhinChistyakov09.logiclayer.moderator;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserStatusGetter;

public class UnblockUserLogic {

	private UserDao userDao;
	private final UserStatusGetter userStatusGetter;

	public UnblockUserLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusGetter = new UserStatusGetter(userStatusDao);
	}

	public void unblockUserById(int userId) throws DataRequestException {
		User user = this.userDao.getUserById(userId);
		UserStatus status = userStatusGetter.getOfflineStatus();
		user.setStatus(status);
		this.userDao.updateUser(user);
	}
}
