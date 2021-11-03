package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;

public class EmptyCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
