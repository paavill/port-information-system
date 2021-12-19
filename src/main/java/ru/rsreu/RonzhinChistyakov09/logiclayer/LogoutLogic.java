package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserStatusGetter;

public class LogoutLogic {

	private final UserDao userDao;
	private final UserStatusGetter userStatusGetter;

	public LogoutLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusGetter = new UserStatusGetter(userStatusDao);
	}

	public void logout(User user) throws DataRequestException {
		UserStatus currentStatus = getCurrentUserStatus(user.getId());
		UserStatus blockStatus = userStatusGetter.getBlockStatus();
		UserStatus deleteStatus = userStatusGetter.getDeleteStatus();
		if (!(currentStatus.equals(blockStatus) || currentStatus.equals(deleteStatus))) {
			user.setStatus(userStatusGetter.getOfflineStatus());
			this.userDao.updateUser(user);
		}
	}

	private UserStatus getCurrentUserStatus(int userId) throws DataRequestException {
		User user = this.userDao.getUserById(userId);
		return user.getStatus();
	}

}
