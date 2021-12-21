package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.edit;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.EditUserPageLogic;

public class ShowEditUserPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		UserDao userDao = (UserDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersRoles"));
		Integer userId = Integer
				.valueOf(request.getParameter(Resourcer.getString("servlet.requests.parametres.userIdToEdit")));

		EditUserPageLogic logic = new EditUserPageLogic(userDao, userRoleDao);

		try {
			User userToEdit = logic.getUserById(userId);
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.userToEdit"), userToEdit);
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.users.roles"), logic.getUserRoles());
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.users.roles.selected"),
					userToEdit.getRole().getTitle());

			String page = Resourcer.getString("jsp.admin.editUser");
			return new CommandResultResponseForward(page);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
	}

}
