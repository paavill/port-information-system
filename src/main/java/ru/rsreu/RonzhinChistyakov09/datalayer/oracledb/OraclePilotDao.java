package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PilotDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OraclePilotDao implements PilotDao {
	
	private Connection connection;

	public OraclePilotDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int getPilotsCount() throws DataRequestException {
		int pilotsCount = 0;
		String query = Resourcer.getString("requests.sql.get.pilots.count");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					pilotsCount = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return pilotsCount;
	}

	@Override
	public int getFreePilotsCount() throws DataRequestException {
		int freePilotsCount = 0;
		String query = Resourcer.getString("requests.sql.get.pilots.free.count");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					freePilotsCount = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return freePilotsCount;
	}

}
