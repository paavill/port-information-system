package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;

public class ShowLoginPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = null;
		page = Resourcer.getString("jsp.login");
		return new CommandResultResponseForward(page);
	}

}
