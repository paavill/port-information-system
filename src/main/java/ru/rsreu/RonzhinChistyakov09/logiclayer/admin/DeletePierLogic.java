package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class DeletePierLogic {

	PierDao pierDao;
	
	public DeletePierLogic(PierDao pierDao) {
		this.pierDao = pierDao;
	}
	
	public void deletePier(int id) throws DataRequestException {
		this.pierDao.deletePier(id);
	}


}
