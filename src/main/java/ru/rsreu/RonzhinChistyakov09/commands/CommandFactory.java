package ru.rsreu.RonzhinChistyakov09.commands;

import javax.servlet.http.HttpServletRequest;

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
