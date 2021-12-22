package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.create;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.captain.CancelStatementLogic;

public class CancelStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsStatuses"));
		int statementId = Integer
				.parseInt(request.getParameter(Resourcer.getString("servlet.requests.parametres.statementId")));
		CancelStatementLogic logic = new CancelStatementLogic(statementDao, statementStatusDao);
			
		logic.cancelStatement(statementId);

		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
	}

}
