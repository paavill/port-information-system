package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.CreateUserPageLogic;

public class ShowCreateUserPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersRoles"));
		CreateUserPageLogic logic = new CreateUserPageLogic(userRoleDao);
		try {
			Collection<UserRole> roles = logic.getUserRoles();
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.users.roles"), roles);
			String page = Resourcer.getString("jsp.admin.createUser");
			return new CommandResultResponseForward(page);
		} catch (DataRequestException e) {
			e.printStackTrace();
			return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
		}
	}
}
