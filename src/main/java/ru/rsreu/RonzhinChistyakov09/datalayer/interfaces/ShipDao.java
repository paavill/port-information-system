package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface ShipDao {
	abstract Collection<Ship> getAllShips() throws DataRequestException;

	abstract Ship getUserShip(int userId) throws DataRequestException;

	abstract void createShip(int userId, Ship ship) throws DataRequestException;

	abstract int getLastId() throws DataRequestException;
}
