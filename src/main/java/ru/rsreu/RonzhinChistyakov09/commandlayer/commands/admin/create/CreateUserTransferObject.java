package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.ServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.DataTransferObject;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateUserTransferObject implements DataTransferObject<User> {

	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	private final UserStatusDao userStatusDao;
	private static final String DEFAULT_USER_STATUS_TITLE = "ACTIVE";

	public CreateUserTransferObject(UserDao userDao, UserRoleDao userRoleDao, UserStatusDao userStatusDao) {
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
		this.userStatusDao = userStatusDao;
	}

	@Override
	public User getModel(ServletRequest request) throws DataRequestException {
		int newUserId = this.userDao.getLastUserId() + 1;
		String login = (String) request.getParameter("userLogin");
		String password = (String) request.getParameter("userPassword");
		String fullName = (String) request.getParameter("userFullName");
		String roleTitle = (String) request.getParameter("role");
		UserRole userRole = this.userRoleDao.getUserRoleByTitle(roleTitle);
		UserStatus userStatus = this.userStatusDao.getUserStatusByTitle(DEFAULT_USER_STATUS_TITLE);
		User user = new User(newUserId, login, password, fullName, userStatus, userRole);
		return user;
	}

}
