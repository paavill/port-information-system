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
		User user = (User) request.getSession().getAttribute(Resourcer.getString("servlet.session.attributes.user"));
		String roleTitle = user.getRole().getTitle().toUpperCase();
		ActionCommandResult resultCommand = null;// there will be command with redirect to error page
		if (roleTitle.equals(Resourcer.getString("database.users.roles.administrator"))) {
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
		} else if (roleTitle.equals(Resourcer.getString("database.users.roles.dispatcher"))) {
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.dispatcher"));
		} else if (roleTitle.equals(Resourcer.getString("database.users.roles.captain"))) {
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
		} else if (roleTitle.equals(Resourcer.getString("database.users.roles.moderator"))) {
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.moderator"));
		} else {
			resultCommand = new CommandResultResponseSendRedirect(Resourcer.getString("uri.empty"));
			System.out.println("########USER ROLE UNDEF#########");
		}
		return resultCommand;
	}

}
