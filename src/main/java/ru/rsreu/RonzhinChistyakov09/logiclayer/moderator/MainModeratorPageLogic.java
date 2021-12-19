package ru.rsreu.RonzhinChistyakov09.logiclayer.moderator;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserStatusGetter;

public class MainModeratorPageLogic {
	private final UserDao userDao;
	private final UserStatusGetter userStatusGetter;

	public MainModeratorPageLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusGetter = new UserStatusGetter(userStatusDao);
	}

	public Collection<User> getBlockedUsers() throws DataRequestException {
		UserStatus blockStatus = this.userStatusGetter.getBlockStatus();
		return userDao.getUsersByStatusId(blockStatus.getId());
	}

	public Collection<User> getActiveUsers() throws DataRequestException {
		UserStatus onlineStatus = this.userStatusGetter.getOnlineStatus();
		UserStatus offlineStatus = this.userStatusGetter.getOfflineStatus();
		Collection<User> result = this.userDao.getUsersByStatusId(onlineStatus.getId());
		result.addAll(this.userDao.getUsersByStatusId(offlineStatus.getId()));
		return result;
	}

}
