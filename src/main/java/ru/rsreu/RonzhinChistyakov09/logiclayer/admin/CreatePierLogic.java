package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.validationlayer.admin.create.CreatePierValidator;
import ru.rsreu.RonzhinChistyakov09.exceptions.InvalidValue;

public class CreatePierLogic {

	private final int MIN_PIER_CAPACITY = 1;
	private final int MAX_PIER_CAPACITY = (int) 1e21 - 1;
	private final PierDao pierDao;
	private final CreatePierValidator validator;

	public CreatePierLogic(PierDao pierDao) {
		this.pierDao = pierDao;
		this.validator = new CreatePierValidator(MAX_PIER_CAPACITY, MIN_PIER_CAPACITY);
	}

	public void createPier(int capacity) throws DataRequestException, InvalidValue {
		int id = pierDao.getLastPierId() + 1;
		if (validator.validate(capacity)) {
			Pier pier = new Pier(id, capacity);
			pierDao.createPier(pier);
		} else {
			throw new InvalidValue(
					String.format(Resourcer.getString("exceptions.captain.create.pier.capacity"), capacity));
		}
	}
}
