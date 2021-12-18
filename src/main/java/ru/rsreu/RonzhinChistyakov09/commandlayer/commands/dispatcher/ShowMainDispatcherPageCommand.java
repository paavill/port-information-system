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
	public ActionCommandResult execute(HttpServletRequest request) {
		StatementDao statementDao = (StatementDao) request.getServletContext().getAttribute("statementDao");
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute("statementStatusDao");
		UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
		UserRoleDao userRoleDao = (UserRoleDao) request.getServletContext().getAttribute("userRoleDao");
		PierDao pierDao = (PierDao) request.getServletContext().getAttribute("pierDao");
		ShipDao shipDao = (ShipDao) request.getServletContext().getAttribute("shipDao");
		MainDispatcherPageLogic logic = new MainDispatcherPageLogic(pierDao, userDao, shipDao, statementDao,
				userRoleDao, statementStatusDao);
		try {

			request.setAttribute("statementsToProcess", logic.getStatements());
			request.setAttribute("captainsData", logic.getCaptains());
			request.setAttribute("piersData", logic.getPiers());
			request.setAttribute("shipsData", logic.getShips());

		} catch (DataRequestException e) {
			e.printStackTrace();
		}

		String page = Resourcer.getString("jsp.dispatcher.main");
		return new CommandResultResponseForward(page);
	}

}
