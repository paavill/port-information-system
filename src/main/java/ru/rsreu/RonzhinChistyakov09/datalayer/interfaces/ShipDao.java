package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * A class that provides access to model objects of the ship type
 * 
 * @author pavel
 *
 */
public interface ShipDao {
	/**
	 * The method allows you to get all kotobli that are available in the
	 * information system
	 * 
	 * @return Collection of ships
	 * @throws DataRequestException
	 */
	Collection<Ship> getAllShips() throws DataRequestException;

	/**
	 * The method allows you to get the captain's ship by the captain's id
	 * 
	 * @param userId - The id of the user to which you want to get
	 * @return Ship object
	 * @throws DataRequestException
	 */
	Ship getUserShip(int userId) throws DataRequestException;

	/**
	 * The method allows you to create a ship and assign a captain to it
	 * 
	 * @param userId - id of the user to whom the ship is assigned
	 * @param ship   - The ship object, by which the ship is created in the data
	 *               warehouse
	 * @throws DataRequestException
	 */
	void createShip(int userId, Ship ship) throws DataRequestException;

	/**
	 * Allows you to get the id of the half of the last created ship
	 * 
	 * @return id
	 * @throws DataRequestException
	 */
	int getLastId() throws DataRequestException;

	/**
	 * Removes a ship from storage, setting a date for decommissioning
	 * 
	 * @param shipId
	 * @throws DataRequestException
	 */
	void deleteShip(int shipId) throws DataRequestException;
}
