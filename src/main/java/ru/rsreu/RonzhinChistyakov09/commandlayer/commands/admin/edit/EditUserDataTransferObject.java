package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.edit;

import javax.servlet.ServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.DataTransferObject;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class EditUserDataTransferObject implements DataTransferObject<User> {

	private final UserDao userDao;
	private final UserRoleDao userRoleDao;

	public EditUserDataTransferObject(UserDao userDao, UserRoleDao userRoleDao) {
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
	}

	@Override
	public User getModel(ServletRequest request) throws DataRequestException {
		Integer id = Integer.parseInt(request.getParameter("currentUserId"));
		String login = (String) request.getParameter("currentUserLogin");
		String password = (String) request.getParameter("currentUserPassword");
		String fullName = (String) request.getParameter("currentUserFullName");
		String roleTitle = (String) request.getParameter("currentUserRole");
		UserRole role = this.userRoleDao.getUserRoleByTitle(roleTitle);
		UserStatus status = this.userDao.getUserById(id).getStatus();
		User user = new User(id, login, password, fullName, status, role);
		return user;
	}

}
