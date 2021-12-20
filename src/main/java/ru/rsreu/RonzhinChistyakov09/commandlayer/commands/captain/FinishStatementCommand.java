package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;

public class FinishStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		System.out.println("FINISH");

		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
	}

}
