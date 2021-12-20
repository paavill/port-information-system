package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.captain.FinishStatementLogic;

public class FinishStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		StatementDao statementDao = (StatementDao) request.getServletContext().getAttribute("statementDao");
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute("statementStatusDao");
		int statementId = Integer.parseInt(request.getParameter("statementId"));
		FinishStatementLogic logic = new FinishStatementLogic(statementDao, statementStatusDao);
		try {
			logic.finishStatement(statementId);
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
	}

}
