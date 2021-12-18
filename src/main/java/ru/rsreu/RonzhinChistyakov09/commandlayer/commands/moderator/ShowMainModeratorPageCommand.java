package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.moderator;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.moderator.MainModeratorPageLogic;

public class ShowMainModeratorPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {

		UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
		UserStatusDao userStatusDao = (UserStatusDao) request.getServletContext().getAttribute("userStatusDao");
		
		MainModeratorPageLogic logic = new MainModeratorPageLogic(userDao, userStatusDao);
		try {
			request.setAttribute("unblockedUsers", logic.getActiveUsers());
			request.setAttribute("blockedUsers", logic.getBlockedUsers());
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String page = Resourcer.getString("jsp.moderator.main");
		return new CommandResultResponseForward(page);
	}

}
