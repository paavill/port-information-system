package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface PierDao {
	abstract Collection<Pier> getAllPiers() throws DataRequestException;
	
	abstract int getPiersCount() throws DataRequestException;
	
	abstract int getFreePiersCount() throws DataRequestException;
}
