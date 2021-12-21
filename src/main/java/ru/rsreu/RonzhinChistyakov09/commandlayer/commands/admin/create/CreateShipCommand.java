package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.CreateShipLogic;

public class CreateShipCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		ShipDao shipDao = (ShipDao) request.getServletContext().getAttribute("shipDao");

		CreateShipTransferObject shipDto = new CreateShipTransferObject(shipDao);
		CreateShipLogic logic = new CreateShipLogic(shipDao);
		try {
			Ship ship = shipDto.getModel(request);
			int userId = Integer
					.parseInt(request.getParameter(Resourcer.getString("servlet.requests.parametres.captainId")));
			logic.createShip(userId, ship);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
	}

}
