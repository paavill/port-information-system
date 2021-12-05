package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.CreateUserLogic;

public class CreateUserCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			CreateUserLogic logic = new CreateUserLogic(userDao);
			String login = (String) request.getParameter("userLogin");
			String password = (String) request.getParameter("userPassword");
			String fullName = (String) request.getParameter("userFullName");
			String roleTitle = (String) request.getParameter("role");

//			Collection<UserRole> roles = (Collection<UserRole>) request.getSession().getAttribute("userRoles");
//			
//			UserRole userRole = null;
//			if (roles != null) {
//				for (UserRole role : roles) {
//					if (role.getTitle().equals(roleTitle)) {
//						userRole = role;
//						break;
//					}
//				}
//			}

			logic.createUser(login, password, fullName, roleTitle);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}

}
