package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher.ProcessStatementLogic;

public class ProcessStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsStatuses"));
		int pierId = Integer.parseInt(request.getParameter("selectedPier"));
		int statementId = Integer.parseInt(request.getParameter("statementId"));

		ProcessStatementLogic logic = new ProcessStatementLogic(statementDao, statementStatusDao);
		try {
			logic.applyStatement(statementId, pierId);
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String page = Resourcer.getString("uri.show.mainPage.dispatcher");
		return new CommandResultResponseSendRedirect(page);
	}

}
