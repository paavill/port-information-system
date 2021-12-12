package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OracleShipDao implements ShipDao {

	private Connection connection;

	public OracleShipDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Collection<Ship> getAllShips() throws DataRequestException {
		Collection<Ship> result = new ArrayList<Ship>();
		String query = Resourcer.getString("requests.sql.get.ships.allShips");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					Ship ship = ResultSetConverter.getShip(resultSet);
					result.add(ship);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
	}

	@Override
	public Ship getUserShip(int userId) throws DataRequestException {
		Ship ship = null;
		String query = Resourcer.getString("requests.sql.get.users.ships");
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			preparedStatement.setInt(1, userId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					ship = ResultSetConverter.getShip(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return ship;
	}

	@Override
	public void createShip(int userId, Ship ship) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.create.ship");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, ship.getId(), userId, ship.getTitle(),
					ship.getCapacity());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	@Override
	public int getLastId() throws DataRequestException {
		int lastShipId = 0;
		String query = Resourcer.getString("requests.sql.get.users.ships.lastId");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				if (resultSet.next()) {
					lastShipId = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return lastShipId;
	}
}
