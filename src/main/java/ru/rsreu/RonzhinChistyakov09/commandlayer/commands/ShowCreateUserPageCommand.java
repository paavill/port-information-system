package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.CreateUserPageLogic;

public class ShowCreateUserPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			CreateUserPageLogic logic = new CreateUserPageLogic(userDao);
			Collection<UserRole> roles;
			roles = logic.getUserRoles();
			request.getSession().setAttribute("userRoles", roles);
			String page = "/jsp/createUserPage.jsp";
			return new CommandResultResponseForward(page);
		} catch (DataRequestException e) {
			e.printStackTrace();
			return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
		}
	}
}
