package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.LogoutLogic;

public class LogoutCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			LogoutLogic logoutLogic = new LogoutLogic(userDao);
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			logoutLogic.logout(user);
			session.removeAttribute("user");
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		String page = "FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE";
		return new CommandResultResponseSendRedirect(page);
	}

}
