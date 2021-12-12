package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateShipPageLogic {

	UserDao userDao;
	
	public CreateShipPageLogic(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public Collection<Integer> getCaptainsId() throws DataRequestException{
		return this.userDao.getCaptainsId();
	}

}
