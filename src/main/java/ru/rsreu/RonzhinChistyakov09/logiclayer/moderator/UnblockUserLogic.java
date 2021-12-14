package ru.rsreu.RonzhinChistyakov09.logiclayer.moderator;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class UnblockUserLogic {

	private static final String ACTIVE_STATUS_TITLE = "ACTIVE";
	private UserDao userDao;
	private UserStatusDao userStatusDao;
	
	public UnblockUserLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusDao = userStatusDao;
	}
	
	public void unblockUserById(int userId) throws DataRequestException {
		User user = this.userDao.getUserById(userId);
		UserStatus status = this.userStatusDao.getUserStatusByTitle(ACTIVE_STATUS_TITLE);
		user.setStatus(status);
		this.userDao.updateUser(user);
	}
}
