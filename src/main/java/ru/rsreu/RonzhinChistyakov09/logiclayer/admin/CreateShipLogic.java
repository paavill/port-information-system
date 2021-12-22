package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.InvalidValue;
import ru.rsreu.RonzhinChistyakov09.validationlayer.admin.create.CreateShipValidator;

public class CreateShipLogic {

	private final int MIN_SHIP_TITLE_LENGTH = 1;
	private final int MAX_SHIP_TITLE_LENGTH = (int) 1e21 - 1;
	private final ShipDao shipDao;
	private final CreateShipValidator validator;

	public CreateShipLogic(ShipDao shipDao, UserDao userDao) {
		this.shipDao = shipDao;
		this.validator = new CreateShipValidator(MIN_SHIP_TITLE_LENGTH, MAX_SHIP_TITLE_LENGTH, userDao);
	}

	public void createShip(Integer userId, Ship ship) throws DataRequestException, InvalidValue {
		if (!validator.validateTitle(ship.getTitle())) {
			throw new InvalidValue(
					String.format(Resourcer.getString("exceptions.captain.create.ship.title"), ship.getTitle()));
		} else if (!validator.validateCaptainId(userId)) {
			throw new InvalidValue(
					String.format(Resourcer.getString("exceptions.captain.create.ship.captainId"), String.valueOf(userId)));
		} else {
			this.shipDao.createShip(userId, ship);
		}
	}

}
