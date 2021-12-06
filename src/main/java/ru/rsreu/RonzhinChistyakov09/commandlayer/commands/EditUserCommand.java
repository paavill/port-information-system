package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.EditUserLogic;

public class EditUserCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			EditUserLogic logic = new EditUserLogic(userDao);
			int userId = Integer.parseInt(request.getParameter("currentUserId"));
			String login = (String) request.getParameter("currentUserLogin");
			String password = (String) request.getParameter("currentUserPassword");
			String fullName = (String) request.getParameter("currentUserFullName");
			String roleTitle = (String) request.getParameter("role");
			String statusTitle = (String) request.getParameter("currentUserStatus");
			logic.editUser(userId, login, password, fullName, statusTitle, roleTitle);
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}

}
