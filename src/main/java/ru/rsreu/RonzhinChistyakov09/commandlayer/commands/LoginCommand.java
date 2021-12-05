package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.UserNotFoundException;
import ru.rsreu.RonzhinChistyakov09.exceptions.WrongPasswordException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.LoginLogic;

public class LoginCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {

		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			LoginLogic loginLogic = new LoginLogic(userDao);
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			User user = loginLogic.login(login, password);
			request.getSession().setAttribute("user", user);
			System.out.println(user.toString());
			return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
		} catch (DataRequestException | UserNotFoundException | WrongPasswordException e) {
			String message;
			if (e instanceof UserNotFoundException) {
				message = "User is not found";
			} else if (e instanceof WrongPasswordException) {
				message = "Password is wrong";
			} else {
				message = "Unknown error";
			}
			String page = Resourcer.getString("jsp.login");
			request.setAttribute("errorMessage", message);
			return new CommandResultResponseForward(page);
		}
	}
}
