package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.CreateUserPageLogic;

public class ShowCreateUserPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		try {
			UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext().getAttribute("userRoleDao");
			CreateUserPageLogic logic = new CreateUserPageLogic(userRoleDao);
			Collection<UserRole> roles = logic.getUserRoles();
			request.setAttribute("userRoles", roles);
			String page = "/jsp/createUserPage.jsp";
			return new CommandResultResponseForward(page);
		} catch (DataRequestException e) {
			e.printStackTrace();
			return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
		}
	}
}
