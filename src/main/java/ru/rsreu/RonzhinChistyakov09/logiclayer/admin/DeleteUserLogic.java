package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.administrator.TryDeleteAdministatorException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserRoleGetter;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserStatusGetter;

public class DeleteUserLogic {

	private final UserDao userDao;
	private final UserStatusGetter userStatusGetter;
	private final UserRoleGetter userRoleGetter;

	public DeleteUserLogic(UserDao userDao, UserStatusDao userStatusDao, UserRoleDao userRoleDao) {
		this.userDao = userDao;
		this.userStatusGetter = new UserStatusGetter(userStatusDao);
		this.userRoleGetter = new UserRoleGetter(userRoleDao);
	}

	public void deleteUser(int id) throws DataRequestException, TryDeleteAdministatorException {
		User user = this.userDao.getUserById(id);
		UserRole administratorRole = this.userRoleGetter.getAdministratorRole();
		if (user.getRole().equals(administratorRole)) {
			throw new TryDeleteAdministatorException(Resourcer.getString("exceptions.captain.delete"));
		}
		UserStatus deletedStatus = this.userStatusGetter.getDeleteStatus();
		user.setStatus(deletedStatus);
		this.userDao.updateUser(user);
	}

}
