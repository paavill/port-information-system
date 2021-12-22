package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.LoginBusyException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.CreateUserLogic;

public class CreateUserCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		UserDao userDao = (UserDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersRoles"));
		UserStatusDao userStatusDao = (UserStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersStatuses"));

		CreateUserLogic logic = new CreateUserLogic(userDao);
		CreateUserTransferObject userDto = new CreateUserTransferObject(userDao, userRoleDao, userStatusDao);
		try {
			User user = userDto.getModel(request);
			logic.createUser(user);
		} catch (LoginBusyException e) {
			request.getServletContext().setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), e.getMessage());
			return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.createUserPage"));
		}
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
	}

}
