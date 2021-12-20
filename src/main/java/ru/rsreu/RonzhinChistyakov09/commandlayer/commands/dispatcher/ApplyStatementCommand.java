package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher.ApplyStatementLogic;

public class ApplyStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsStatuses"));

		int statementId = Integer.parseInt(
				request.getParameter(Resourcer.getString("servlet.requests.parametres.statementIdToProcess")));
		
		ApplyStatementLogic logic = new ApplyStatementLogic(statementDao, statementStatusDao);
		try {
			StatementType type = logic.getStatementType(statementId);
			System.out.println(type.getTitle());
			if (type.getId() == 0) {
				int pierId = Integer.parseInt(request.getParameter("selectedPier"));
				logic.applyStatement(statementId, pierId);
			} else {
				logic.applyStatement(statementId);
			}

		} catch (DataRequestException e) {
			e.printStackTrace();
		}

		String page = Resourcer.getString("uri.show.mainPage.dispatcher");
		return new CommandResultResponseSendRedirect(page);
	}

}
