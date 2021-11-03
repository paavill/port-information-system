package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface PierDao {
	abstract int getPiersCount() throws DataRequestException;
	
	abstract int getFreePiersCount() throws DataRequestException;
}
