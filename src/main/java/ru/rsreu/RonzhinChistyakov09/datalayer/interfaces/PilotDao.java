package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pilot.Pilot;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface PilotDao {
	abstract Collection<Pilot> getAllPilots() throws DataRequestException;
	
	abstract int getPilotsCount() throws DataRequestException;
	
	abstract int getFreePilotsCount() throws DataRequestException;
	
	abstract void createPilot(Pilot Pilot) throws DataRequestException;
	
	abstract void updatePilot(Pilot Pilot) throws DataRequestException;
}
