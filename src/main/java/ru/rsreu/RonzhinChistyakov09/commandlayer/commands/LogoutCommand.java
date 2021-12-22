package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.LogoutLogic;

public class LogoutCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		UserDao userDao = (UserDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		UserStatusDao userStatusDao = (UserStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersStatuses"));
		LogoutLogic logoutLogic = new LogoutLogic(userDao, userStatusDao);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Resourcer.getString("servlet.session.attributes.user"));

		logoutLogic.logout(user);
		session.invalidate();

		String page = Resourcer.getString("uri.show.mainPage.noLogin");
		return new CommandResultResponseSendRedirect(page);
	}

}
