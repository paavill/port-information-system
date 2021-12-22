package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.InvalidValue;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.CreateShipLogic;

public class CreateShipCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		ShipDao shipDao = (ShipDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.ships"));
		UserDao userDao = (UserDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		CreateShipTransferObject shipDto = new CreateShipTransferObject(shipDao);
		CreateShipLogic logic = new CreateShipLogic(shipDao, userDao);
		Ship ship = shipDto.getModel(request);
		Integer userId = (Integer) null;
		try {
			userId = Integer
					.parseInt(request.getParameter(Resourcer.getString("servlet.requests.parametres.captainId")));
		} catch (NumberFormatException e) {
			request.getServletContext().setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), String
					.format(Resourcer.getString("exceptions.captain.create.ship.captainId"), String.valueOf(userId)));
			return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.createShipPage"));
		}

		try {
			logic.createShip(userId, ship);
		} catch (InvalidValue e) {
			request.getServletContext().setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), e.getMessage());
			return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.createShipPage"));
		}
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
	}

}
