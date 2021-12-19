package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.BlockUserException;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.UserNotFoundException;
import ru.rsreu.RonzhinChistyakov09.exceptions.WrongPasswordException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.LoginLogic;

public class LoginCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		UserDao userDao = (UserDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		UserStatusDao userStatusDao = (UserStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersStatuses"));
		LoginLogic loginLogic = new LoginLogic(userDao, userStatusDao);
		String login = request.getParameter(Resourcer.getString("servlet.requests.parametres.login"));
		String password = request.getParameter(Resourcer.getString("servlet.requests.parametres.password"));
		try {
			User user = loginLogic.login(login, password);
			request.getSession().setAttribute(Resourcer.getString("servlet.session.attributes.user"), user);
			return new CommandResultResponseSendRedirect(Resourcer.getString("uri.routing"));
		} catch (DataRequestException | UserNotFoundException | WrongPasswordException | BlockUserException e) {
			String message;
			if (e instanceof UserNotFoundException) {
				message = String.format(Resourcer.getString("exceptions.login.userNotFound"), login);
			} else if (e instanceof WrongPasswordException) {
				message = Resourcer.getString("exceptions.login.wrongPassword");
			} else if (e instanceof BlockUserException) {
				message = Resourcer.getString("exceptions.login.blockUser");
			} else {
				message = Resourcer.getString("exceptions.unknown");
			}
			String page = Resourcer.getString("jsp.login");
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), message);
			return new CommandResultResponseForward(page);
		}
	}
}
