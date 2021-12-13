package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class DeleteUserLogic {

	UserDao userDao;
	UserStatusDao userStatusDao;
	
	public DeleteUserLogic(UserDao userDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userStatusDao = userStatusDao;
	}
	
	public void deleteUser(int id) throws DataRequestException {
		User user = this.userDao.getUserById(id);
		UserStatus status = this.userStatusDao.getUserStatusByTitle("DELETED");
		user.setStatus(status);
		this.userDao.updateUser(user);
	}

}
