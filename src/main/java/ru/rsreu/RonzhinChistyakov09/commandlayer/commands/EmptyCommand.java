package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;

public class EmptyCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		return new CommandResultResponseForward(Resourcer.getString("jsp.undefinedCommand"));
	}

}
