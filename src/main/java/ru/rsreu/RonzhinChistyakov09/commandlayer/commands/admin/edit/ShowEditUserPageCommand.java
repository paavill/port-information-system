package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.edit;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.EditUserPageLogic;

public class ShowEditUserPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext().getAttribute("userRoleDao");
			EditUserPageLogic logic = new EditUserPageLogic(userDao, userRoleDao);
			Integer userId = Integer.valueOf(request.getParameter("userIdToEdit"));
			User userToEdit = logic.getUserById(userId);
			Collection<UserRole> userRoles = logic.getUserRoles();

			request.setAttribute("userToEdit", userToEdit);
			request.setAttribute("userRoles", userRoles);
			request.setAttribute("selectedUserRole", userToEdit.getRole().getTitle());

			String page = Resourcer.getString("jsp.admin.editUser");
			return new CommandResultResponseForward(page);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}

}
