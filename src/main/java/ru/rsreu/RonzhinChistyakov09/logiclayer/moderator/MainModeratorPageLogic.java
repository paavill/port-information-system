package ru.rsreu.RonzhinChistyakov09.logiclayer.moderator;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class MainModeratorPageLogic {
	private UserDao userDao;
	private UserStatusDao userStatusDao;
	private static final String BLOCKED_STATUS_TITLE = "BLOCKED";
	private static final String ACTIVE_STATUS_TITLE = "ACTIVE";
	
	public MainModeratorPageLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusDao = userStatusDao;
	}
	
	public Collection<User> getBlockedUsers() throws DataRequestException{
		UserStatus status = this.userStatusDao.getUserStatusByTitle(BLOCKED_STATUS_TITLE);
		return userDao.getUsersByStatusId(status.getId());
	}
	
	public Collection<User> getActiveUsers() throws DataRequestException{
		UserStatus status = this.userStatusDao.getUserStatusByTitle(ACTIVE_STATUS_TITLE);
		return userDao.getUsersByStatusId(status.getId());
	}

}
