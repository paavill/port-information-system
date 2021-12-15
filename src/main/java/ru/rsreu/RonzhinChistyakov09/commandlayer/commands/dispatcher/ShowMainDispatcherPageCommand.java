package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class ShowMainDispatcherPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		String page = Resourcer.getString("jsp.dispatcher.main");
		StatementDao statementDao = (StatementDao) request.getAttribute("statementDao");// throws nullptr
		Collection<Statement> statements = new ArrayList<Statement>();// = statementDao.getAllStatements();

		// shipsData
		// captainsData
		// check attributes in jsp that need to set
		return new CommandResultResponseForward(page);
	}

}
