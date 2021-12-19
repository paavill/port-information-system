package ru.rsreu.RonzhinChistyakov09.logiclayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserStatusGetter;

public class LogoutLogic {

	private final UserDao userDao;
	private final UserStatusDao userStatusDao;

	public LogoutLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusDao = userStatusDao;
	}

	public void logout(User user) throws DataRequestException {
		UserStatus currentStatus = getCurrentUserStatus(user.getId());
		UserStatusGetter getter = new UserStatusGetter(this.userStatusDao);
		UserStatus blockStatus = getter.getBlockStatus();
		UserStatus deleteStatus = getter.getDeleteStatus();
		if (!(currentStatus.equals(blockStatus) || currentStatus.equals(deleteStatus))) {
			user.setStatus(getter.getOfflineStatus());
			this.userDao.updateUser(user);
		}
	}

	private UserStatus getCurrentUserStatus(int userId) throws DataRequestException {
		User user = this.userDao.getUserById(userId);
		return user.getStatus();
	}

}
