package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.ServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.DataTransferObject;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.UserStatusGetter;

public class CreateUserTransferObject implements DataTransferObject<User> {

	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	private final UserStatusGetter userStatusGetter;

	public CreateUserTransferObject(UserDao userDao, UserRoleDao userRoleDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
		this.userStatusGetter = new UserStatusGetter(userStatusDao);
	}

	@Override
	public User getModel(ServletRequest request) throws DataRequestException {
		int id = this.userDao.getLastUserId() + 1;
		String login = (String) request.getParameter(Resourcer.getString("servlet.requests.patametres.user.login"));
		String password = (String) request
				.getParameter(Resourcer.getString("servlet.requests.patametres.user.password"));
		String fullName = (String) request
				.getParameter(Resourcer.getString("servlet.requests.patametres.user.fullName"));
		String roleTitle = (String) request.getParameter(Resourcer.getString("servlet.requests.patametres.user.role"));
		UserRole userRole = this.userRoleDao.getUserRoleByTitle(roleTitle);
		UserStatus offlineStatus = this.userStatusGetter.getOfflineStatus();
		User user = new User(id, login, password, fullName, offlineStatus, userRole);
		return user;
	}

}
