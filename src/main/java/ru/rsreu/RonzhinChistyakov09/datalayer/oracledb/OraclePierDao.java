package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OraclePierDao implements PierDao {

	private Connection connection;

	public OraclePierDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int getPiersCount() throws DataRequestException {
		int piersCount = 0;
		String query = Resourcer.getString("requests.sql.get.piers.count");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					piersCount = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return piersCount;
	}

	@Override
	public int getFreePiersCount() throws DataRequestException {
		int freePiersCount = 0;
		String query = Resourcer.getString("requests.sql.get.piers.free.count");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					freePiersCount = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return freePiersCount;
	}
	
}
