package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.administrator.TryDeleteUseShipException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.DeleteShipLogic;

public class DeleteShipCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		ShipDao shipDao = (ShipDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.ships"));
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		int shipId = Integer
				.parseInt(request.getParameter(Resourcer.getString("servlet.requests.parametres.shipIdToDelete")));
		DeleteShipLogic logic = new DeleteShipLogic(statementDao, shipDao);
		try {
			logic.deleteShip(shipId);
		} catch (TryDeleteUseShipException e) {
			request.getServletContext().setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), e.getMessage());
		}
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
	}

}
