package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;

public class RoutingUserCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		String roleTitle =  user.getRole().getTitle().toUpperCase();
		ActionCommandResult resultCommand = null;//there will be command with redirect to error page 
		switch(roleTitle) {
		case "ADMINISTRATOR":
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
			break;
		case "DISPATCHER":
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.dispatcher"));
			break;
		case "CAPTAIN":
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
			break;
		case "MODERATOR":
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.moderator"));
			break;
		default:
			//add error routing page
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.empty"));
			System.out.println("########USER ROLE UNDEF#########");
			break;
		}
		return resultCommand;
	}

}
