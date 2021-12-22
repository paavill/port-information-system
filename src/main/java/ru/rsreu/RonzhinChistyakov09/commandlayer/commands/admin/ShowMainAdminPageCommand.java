package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.MainAdminPageLogic;

public class ShowMainAdminPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		UserDao userDao = (UserDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		PierDao pierDao = (PierDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.piers"));
		ShipDao shipDao = (ShipDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.ships"));

		MainAdminPageLogic logic = new MainAdminPageLogic(pierDao, userDao, shipDao);
		request.setAttribute(Resourcer.getString("servlet.requests.attributes.users"), logic.getUsers());
		request.setAttribute(Resourcer.getString("servlet.requests.attributes.piers"), logic.getPiers());
		request.setAttribute(Resourcer.getString("servlet.requests.attributes.ships"), logic.getShips());

		String page = Resourcer.getString("jsp.admin.main");
		return new CommandResultResponseForward(page);
	}

}
