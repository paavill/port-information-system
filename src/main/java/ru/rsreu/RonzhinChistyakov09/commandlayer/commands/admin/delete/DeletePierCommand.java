package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.administrator.TryDeleteBusyPierException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.DeletePierLogic;

public class DeletePierCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		PierDao pierDao = (PierDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.piers"));
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsStatuses"));
		StatementTypeDao statementTypeDao = (StatementTypeDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsTypes"));

		int pierId = Integer
				.parseInt(request.getParameter(Resourcer.getString("servlet.requests.parametres.pierIdToDelete")));

		DeletePierLogic logic = new DeletePierLogic(pierDao, statementDao, statementTypeDao, statementStatusDao);

		try {
			logic.deletePier(pierId);
		} catch (DataRequestException e) {
			throw e;
		} catch (TryDeleteBusyPierException e) {
			e.printStackTrace();
		}

		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
	}
}
