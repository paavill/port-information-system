package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OraclePierDao implements PierDao {

	private Connection connection;

	public OraclePierDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Collection<Pier> getAllPiers() throws DataRequestException {
		Collection<Pier> result = new ArrayList<Pier>();
		String query = Resourcer.getString("requests.sql.get.piers.allPiers");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					Pier pier = getPierFromResultSet(resultSet);
					result.add(pier);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
	}

	private Pier getPierFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(Resourcer.getString("database.piers.id"));
		int capacity = resultSet.getInt(Resourcer.getString("database.piers.capacity"));
		int residualCapacity = resultSet.getInt(Resourcer.getString("database.piers.capacity.residual"));
		Pier pier = new Pier(id, capacity, residualCapacity);
		return pier;
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
		return freePiersCount;
	}

	@Override
	public void createPier(Pier pier) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.create.pier");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setPierParametresOnPreparedStatement(pier, preparedStatement);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	private void setPierParametresOnPreparedStatement(Pier pier, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setInt(1, pier.getId());
		preparedStatement.setInt(3, pier.getCapacity());
	}

	@Override
	public void updatePier(Pier pier) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.update.pier");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}
}
