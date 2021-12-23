package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher.ProcessStatementLogic;

public class ProcessStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementTypeDao statementTypeDao = (StatementTypeDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsTypes"));
		int statementId = Integer.parseInt(
				request.getParameter(Resourcer.getString("servlet.requests.parametres.statementIdToProcess")));
		ProcessStatementLogic logic = new ProcessStatementLogic(statementDao, statementTypeDao);

		StatementType type = logic.getStatementType(statementId);
		StatementType enterType = logic.getEnterStatementType();
		if (type.equals(enterType)) {
			return new CommandResultResponseForward(Resourcer.getString("uri.show.processStatementPage"));
		} else {
			return new CommandResultResponseForward(Resourcer.getString("uri.applyStatement"));
		}
	}
}
