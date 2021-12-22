package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.create;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.captain.TryCreateStatementWithoutShipException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.captain.CreateStatementLogic;

public class CreateStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		User user = (User) request.getSession().getAttribute(Resourcer.getString("servlet.session.attributes.user"));
		ShipDao shipDao = (ShipDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.ships"));
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsStatuses"));
		StatementTypeDao statementTypeDao = (StatementTypeDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsTypes"));

		CreateStatementTransferObject csto = new CreateStatementTransferObject(shipDao, statementDao,
				statementStatusDao, statementTypeDao);

		Statement statement = csto.getModel(request);
		CreateStatementLogic logic = new CreateStatementLogic(statementDao, statementTypeDao);
		try {
			logic.createStatement(statement, user);
		} catch (TryCreateStatementWithoutShipException e) {
			request.setAttribute("errorMessage", "You don't have a ship");
		}

		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
	}
}
