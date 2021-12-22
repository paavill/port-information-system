package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.dispatcher.MainDispatcherPageLogic;

public class ShowMainDispatcherPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsStatuses"));
		UserDao userDao = (UserDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersRoles"));
		PierDao pierDao = (PierDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.piers"));
		ShipDao shipDao = (ShipDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.ships"));
		MainDispatcherPageLogic logic = new MainDispatcherPageLogic(pierDao, userDao, shipDao, statementDao,
				userRoleDao, statementStatusDao);

		request.setAttribute(Resourcer.getString("servlet.requests.attributes.statementsToProcess"),
				logic.getStatements());
		request.setAttribute(Resourcer.getString("servlet.requests.attributes.captains"), logic.getCaptains());
		request.setAttribute(Resourcer.getString("servlet.requests.attributes.piers"), logic.getPiers());
		request.setAttribute(Resourcer.getString("servlet.requests.attributes.ships"), logic.getShips());

		String page = Resourcer.getString("jsp.dispatcher.main");
		return new CommandResultResponseForward(page);
	}

}
