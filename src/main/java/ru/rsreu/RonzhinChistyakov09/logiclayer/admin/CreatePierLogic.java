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
		int newPierId = getNewPierId();
		Pier pier = new Pier(newPierId, capacity);
		pierDao.createPier(pier);
	}
	
	private int getNewPierId() throws DataRequestException {
		return pierDao.getLastPierId() + 1;
	}
}
