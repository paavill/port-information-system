package ru.rsreu.RonzhinChistyakov09.validationlayer.admin.create;

import java.util.ArrayList;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class CreateShipValidator{
	private final int maxTitleLength;
	private final int minTitleLength;
	private final UserDao userDao;

	public CreateShipValidator(int minTitleLength, int maxTitleLength, UserDao userDao) {
		super();
		this.maxTitleLength = maxTitleLength;
		this.minTitleLength = minTitleLength;
		this.userDao = userDao;
	}

	public boolean validateTitle(String value) {
		if(value != null) {
			return !(value.length() > this.maxTitleLength || value.length() < this.minTitleLength);
		} else {
			return false;
		}
	}
	
	public boolean validateCaptainId(Integer id) throws DataRequestException {
		if(id != null) {
			ArrayList<Integer> captainsIds = new ArrayList<Integer>(this.userDao.getCaptainsId());
			return captainsIds.indexOf(id) != -1;
		} else {
			return false;
		}
	}

}
