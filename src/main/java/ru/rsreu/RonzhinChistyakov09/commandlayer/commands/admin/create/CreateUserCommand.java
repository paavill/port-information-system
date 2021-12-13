package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.http.HttpServletRequest;

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
	public ActionCommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext().getAttribute("userRoleDao");
			UserStatusDao userStatusDao = (UserStatusDao) request.getServletContext().getAttribute("userStatusDao");
			
			CreateUserLogic logic = new CreateUserLogic(userDao);
			CreateUserTransferObject userDto = new CreateUserTransferObject(userDao, userRoleDao, userStatusDao);
			User user = userDto.getModel(request);
			logic.createUser(user);
		} catch (DataRequestException e) {
			e.printStackTrace();
		} catch (LoginBusyException e) {
			System.out.println("Login is busy");
			e.printStackTrace();
		}
		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}

}
