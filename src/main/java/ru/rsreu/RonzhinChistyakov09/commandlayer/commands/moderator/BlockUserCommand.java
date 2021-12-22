package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.moderator;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.moderator.TryBlockAdministratorException;
import ru.rsreu.RonzhinChistyakov09.exceptions.moderator.TryBlockModeratorException;
import ru.rsreu.RonzhinChistyakov09.exceptions.moderator.UserDeletedException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.moderator.BlockUserLogic;

public class BlockUserCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		UserDao userDao = (UserDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		UserStatusDao userStatusDao = (UserStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersStatuses"));
		UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersRoles"));
		int userId = Integer
				.parseInt(request.getParameter(Resourcer.getString("servlet.requests.parametres.userIdToBlock")));

		BlockUserLogic logic = new BlockUserLogic(userDao, userStatusDao, userRoleDao);
		try {
			logic.blockUserById(userId);
		} catch (DataRequestException e) {
			request.getServletContext().setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), e.getMessage());
		} catch (TryBlockAdministratorException e) {
			request.getServletContext().setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), e.getMessage());
		} catch (TryBlockModeratorException e) {
			request.getServletContext().setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), e.getMessage());
		} catch (UserDeletedException e) {
			request.getServletContext().setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), e.getMessage());
		}
		String page = Resourcer.getString("uri.show.mainPage.moderator");
		return new CommandResultResponseSendRedirect(page);
	}

}
