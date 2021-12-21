package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreatePierLogic {

	PierDao pierDao;

	public CreatePierLogic(PierDao pierDao) {
		this.pierDao = pierDao;
	}

	public void createPier(int capacity) throws DataRequestException {
		int id = pierDao.getLastPierId() + 1;
		Pier pier = new Pier(id, capacity);
		pierDao.createPier(pier);
	}
}
