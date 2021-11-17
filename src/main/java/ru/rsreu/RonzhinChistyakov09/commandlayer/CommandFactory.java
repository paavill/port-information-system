package ru.rsreu.RonzhinChistyakov09.commandlayer;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.EmptyCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;

public class CommandFactory {
	public static ICommand getCommand(HttpServletRequest request) {
		ICommand current = new EmptyCommand();

		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			return current;
		}

		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			System.out.println("err! enum exception in ActionFactory");
			// request.setAttribute("wrongAction", action
			// + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}