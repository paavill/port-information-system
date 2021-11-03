package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface PilotDao {
	abstract int getPilotsCount() throws DataRequestException;
	
	abstract int getFreePilotsCount() throws DataRequestException;
}
