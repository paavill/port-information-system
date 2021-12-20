package ru.rsreu.RonzhinChistyakov09.commandlayer;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.EmptyCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;

public class CommandFactory {
	public static ActionCommand getCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();

		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			return current;
		}

		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute(Resourcer.getString("jsp.undefinedCommand.errorCommand"), action);
		}
		return current;
	}
}
