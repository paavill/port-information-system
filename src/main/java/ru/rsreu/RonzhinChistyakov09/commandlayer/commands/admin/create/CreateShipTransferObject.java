package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.ServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.DataTransferObject;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateShipTransferObject implements DataTransferObject<Ship> {

	private ShipDao shipDao;
	
	public CreateShipTransferObject(ShipDao shipDao) {
		this.shipDao = shipDao;
	}

	@Override
	public Ship getModel(ServletRequest request) throws DataRequestException {
		int id = shipDao.getLastId() + 1;
		String title = request.getParameter("shipTitle");
		Ship ship = new Ship(id, title);
		return ship;
	}

}
