package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;

public class ShowProcessStatementPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		String page = Resourcer.getString("jsp.dispatcher.processStatement");
		return new CommandResultResponseForward(page);
	}

}
