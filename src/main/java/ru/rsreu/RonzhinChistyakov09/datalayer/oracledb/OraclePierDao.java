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
					Pier pier = ResultSetConverter.getPier(resultSet);
					result.add(pier);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
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
		int freePiersCount = -2;
		return freePiersCount;
	}

	@Override
	public void createPier(Pier pier) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.create.pier");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, pier.getId(), pier.getCapacity());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	@Override
	public void updatePier(int pierId, Pier pier) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.update.pier");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, pier.getId(), pier.getCapacity(), pierId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}
}
