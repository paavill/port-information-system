package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.EditUserPageLogic;

public class ShowEditUserPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			EditUserPageLogic logic = new EditUserPageLogic(userDao);
			Integer userId = Integer.valueOf(request.getParameter("userIdToEdit"));
			User userToEdit = logic.getUserById(userId);
			Collection<UserRole> userRoles = logic.getUserRoles();

			request.setAttribute("userToEdit", userToEdit);
			request.setAttribute("userRoles", userRoles);
			request.setAttribute("selectedUserRole", userToEdit.getRole().getTitle());

			String page = "/jsp/editUserPage.jsp";
			return new CommandResultResponseForward(page);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}

}
