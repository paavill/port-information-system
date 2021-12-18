package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher.RejectStatementLogic;

public class RejectStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		StatementDao statementDao = (StatementDao) request.getServletContext().getAttribute("statementDao");
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute("statementStatusDao");
		int statementId = Integer.parseInt(request.getParameter("statementIdToReject"));
		RejectStatementLogic logic = new RejectStatementLogic(statementDao, statementStatusDao);
		try {
			logic.rejectStatement(statementId);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		String page = Resourcer.getString("uri.show.mainPage.dispatcher");
		return new CommandResultResponseSendRedirect(page);
	}

}
