package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateShipLogic {
	
	private ShipDao shipDao;
	
	public CreateShipLogic(ShipDao shipDao) {
		this.shipDao = shipDao;
	}
	
	public void createShip(int userId, Ship ship) throws DataRequestException {
		this.shipDao.createShip(userId, ship);
	}

}
