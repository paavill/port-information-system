package ru.rsreu.RonzhinChistyakov09.logiclayer.moderator;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class BlockUserLogic {

	private static final String BLOCKED_STATUS_TITLE = "BLOCKED";
	private UserDao userDao;
	private UserStatusDao userStatusDao;
	
	public BlockUserLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusDao = userStatusDao;
	}
	
	public void blockUserById(int userId) throws DataRequestException {
		User user = this.userDao.getUserById(userId);
		UserStatus status = this.userStatusDao.getUserStatusByTitle(BLOCKED_STATUS_TITLE);
		user.setStatus(status);
		this.userDao.updateUser(user);
	}
}
