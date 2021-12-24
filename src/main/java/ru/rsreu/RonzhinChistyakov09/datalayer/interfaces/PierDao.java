package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * A class that provides access to objects of the pier model
 * 
 * @author pavel
 *
 */
public interface PierDao {

	/**
	 * Returns the piers in the system
	 * 
	 * @return All piers objects in system
	 * @throws DataRequestException
	 */
	Collection<Pier> getAllPiers() throws DataRequestException;

	/**
	 * Returns the total number of piers in the system
	 * 
	 * @return Number of piers
	 * @throws DataRequestException
	 */
	int getPiersCount() throws DataRequestException;

	/**
	 * Returns piers that may be occupied by captains
	 * 
	 * @return Piers
	 * @throws DataRequestException
	 */
	Collection<Pier> getFreePiers() throws DataRequestException;

	/**
	 * Returns the number of piers that can be occupied by captains
	 * 
	 * @return Piers count
	 * @throws DataRequestException
	 */
	int getFreePiersCount() throws DataRequestException;

	/**
	 * Returns the id of the last created pier
	 * 
	 * @return pier id
	 * @throws DataRequestException
	 */
	int getLastPierId() throws DataRequestException;

	/**
	 * Creates a new pier based on an object in storage
	 * 
	 * @param pier
	 * @throws DataRequestException
	 */
	void createPier(Pier pier) throws DataRequestException;

	/**
	 * Updates pier based on object in storage
	 * 
	 * @param pierId
	 * @param pier
	 * @throws DataRequestException
	 */
	void updatePier(int pierId, Pier pier) throws DataRequestException;

	/**
	 * Delete pier based on object in storage
	 * 
	 * @param id
	 * @throws DataRequestException
	 */
	void deletePier(int id) throws DataRequestException;

	/**
	 * Returns residual capacity on pier by pier's id
	 * 
	 * @param id
	 * @return
	 * @throws DataRequestException
	 */
	int getResidualCapacity(int id) throws DataRequestException;

}
