package ru.rsreu.RonzhinChistyakov09.logiclayer.moderator;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.moderator.TryBlockAdministratorException;
import ru.rsreu.RonzhinChistyakov09.exceptions.moderator.TryBlockModeratorException;
import ru.rsreu.RonzhinChistyakov09.exceptions.moderator.UserDeletedException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserRoleGetter;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserStatusGetter;

public class BlockUserLogic {

	private UserDao userDao;
	private final UserStatusGetter userStatusGetter;
	private final UserRoleGetter userRoleGetter;

	public BlockUserLogic(UserDao userDao, UserStatusDao userStatusDao, UserRoleDao userRoleDao) {
		this.userDao = userDao;
		this.userStatusGetter = new UserStatusGetter(userStatusDao);
		this.userRoleGetter = new UserRoleGetter(userRoleDao);
	}

	public void blockUserById(int userId) throws DataRequestException, TryBlockAdministratorException,
			TryBlockModeratorException, UserDeletedException {
		User user = this.userDao.getUserById(userId);

		UserStatus status = user.getStatus();
		UserStatus deletedStatus = this.userStatusGetter.getDeleteStatus();
		if (status.equals(deletedStatus)) {
			throw new UserDeletedException(Resourcer.getString("exceptions.moderator.userDeleted"));
		}

		UserRole role = user.getRole();
		UserRole administratorRole = this.userRoleGetter.getAdministratorRole();
		if (role.equals(administratorRole)) {
			throw new TryBlockAdministratorException(Resourcer.getString("exceptions.moderator.adminBlock"));
		}
		UserRole moderatorRole = this.userRoleGetter.getModeratorRole();
		if (role.equals(moderatorRole)) {
			throw new TryBlockModeratorException(Resourcer.getString("exceptions.moderator.mdoerBlock"));
		}

		UserStatus blockStatus = this.userStatusGetter.getBlockStatus();
		user.setStatus(blockStatus);
		this.userDao.updateUser(user);
	}
}
