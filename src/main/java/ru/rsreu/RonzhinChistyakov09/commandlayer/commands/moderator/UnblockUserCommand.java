package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.moderator;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.moderator.UnblockUserLogic;

public class UnblockUserCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
		UserStatusDao userStatusDao = (UserStatusDao) request.getServletContext().getAttribute("userStatusDao");
		int userId = Integer.parseInt(request.getParameter("userIdToUnblock"));
		
		UnblockUserLogic logic = new UnblockUserLogic(userDao, userStatusDao);
		try {
			logic.unblockUserById(userId);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		String page = Resourcer.getString("uri.show.mainPage.moderator");
		return new CommandResultResponseSendRedirect(page);
	}

}
