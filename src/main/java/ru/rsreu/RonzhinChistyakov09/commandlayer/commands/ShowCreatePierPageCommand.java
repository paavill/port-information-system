package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;

public class ShowCreatePierPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = "";

		return new CommandResultResponseForward(page);
	}

}
