package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;

public class EmptyCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
