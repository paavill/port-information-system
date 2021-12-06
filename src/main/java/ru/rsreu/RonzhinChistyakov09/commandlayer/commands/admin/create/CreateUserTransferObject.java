package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.ServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.DataTransferObject;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateUserTransferObject implements DataTransferObject<User> {

	private final UserDao userDao;
	private static final UserStatus DEFAULT_USER_STATUS = new UserStatus(0, "");
	
	public CreateUserTransferObject(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public User getModel(ServletRequest request) throws DataRequestException {
		int newUserId = this.userDao.getLastUserId() + 1;
		String login = (String) request.getParameter("userLogin");
		String password = (String) request.getParameter("userPassword");
		String fullName = (String) request.getParameter("userFullName");
		String roleTitle = (String) request.getParameter("role");
		UserRole userRole = this.userDao.getUserRoleByTitle(roleTitle);
		User user = new User(newUserId, login, password, fullName, DEFAULT_USER_STATUS, userRole);
		return user;
	}

}
