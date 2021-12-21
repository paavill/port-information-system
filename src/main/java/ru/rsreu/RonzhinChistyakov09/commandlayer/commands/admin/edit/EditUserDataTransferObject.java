package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.edit;

import javax.servlet.ServletRequest;

import com.prutzkow.resourcer.Resourcer;

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
		Integer id = Integer
				.parseInt(request.getParameter(Resourcer.getString("servlet.requests.patametres.user.current.id")));
		String login = (String) request
				.getParameter(Resourcer.getString("servlet.requests.patametres.user.current.login"));
		String password = (String) request
				.getParameter(Resourcer.getString("servlet.requests.patametres.user.current.password"));
		String fullName = (String) request
				.getParameter(Resourcer.getString("servlet.requests.patametres.user.current.fullName"));
		String roleTitle = (String) request
				.getParameter(Resourcer.getString("servlet.requests.patametres.user.current.role"));

		UserRole role = this.userRoleDao.getUserRoleByTitle(roleTitle);
		UserStatus status = this.userDao.getUserById(id).getStatus();
		return new User(id, login, password, fullName, status, role);
	}

}
