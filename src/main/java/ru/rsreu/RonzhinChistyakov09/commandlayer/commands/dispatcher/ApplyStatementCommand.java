package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher.ApplyStatementLogic;
import ru.rsreu.RonzhinChistyakov09.logiclayer.getters.StatementTypeGetter;

public class ApplyStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsStatuses"));
		StatementTypeDao statementTypeDao = (StatementTypeDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsTypes"));
		int statementId = Integer.parseInt(
				request.getParameter(Resourcer.getString("servlet.requests.parametres.statementIdToProcess")));
		StatementTypeGetter statementTypeGetter = new StatementTypeGetter(statementTypeDao);
		ApplyStatementLogic logic = new ApplyStatementLogic(statementDao, statementStatusDao);
		try {
			StatementType type = logic.getStatementType(statementId);
			StatementType enterType = statementTypeGetter.getEnterType();
			if (type.equals(enterType)) {
				int pierId = Integer.parseInt(
						request.getParameter(Resourcer.getString("servlet.requests.parametres.selectedPier")));
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
