package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface ShipDao {
	Collection<Ship> getAllShips() throws DataRequestException;

	Ship getUserShip(int userId) throws DataRequestException;

	void createShip(int userId, Ship ship) throws DataRequestException;

	int getLastId() throws DataRequestException;

	void deleteShip(int shipId) throws DataRequestException;
}
