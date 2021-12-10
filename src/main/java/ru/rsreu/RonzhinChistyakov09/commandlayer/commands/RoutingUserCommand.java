package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

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
			resultCommand = new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
			break;
		case "DISPATCHER":
			resultCommand = new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
			break;
		case "CAPTAIN":
			resultCommand = new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
			break;
		case "MODERATOR":
			resultCommand = new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
			break;
		default:
			break;
		}
		return resultCommand;
	}

}
