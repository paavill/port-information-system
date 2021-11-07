package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.pilot.Pilot;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pilot.PilotStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PilotDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OraclePilotDao implements PilotDao {

	private Connection connection;

	public OraclePilotDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Collection<Pilot> getAllPilots() throws DataRequestException {
		Collection<Pilot> result = new ArrayList<Pilot>();
		String query = Resourcer.getString("requests.sql.get.pilot.allPilots");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					Pilot pilot = getPilotFromResultSet(resultSet);
					result.add(pilot);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
	}

	private Pilot getPilotFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(Resourcer.getString("database.pilots.id"));
		PilotStatus status = PilotStatus
				.valueOf(resultSet.getString(Resourcer.getString("database.pilots.status")).trim());
		String fullName = resultSet.getString(Resourcer.getString("database.pilots.fullName"));
		Pilot pilot = new Pilot(id, status, fullName);
		return pilot;
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

	@Override
	public void createPilot(Pilot pilot) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.create.pilot");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setPilotParametresOnPreparedStatement(pilot, preparedStatement);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	private void setPilotParametresOnPreparedStatement(Pilot pilot, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setInt(1, pilot.getId());
		preparedStatement.setString(2, pilot.getStatus().toString());
		preparedStatement.setString(3, pilot.getFullName());
	}

	@Override
	public void updatePilot(Pilot pilot) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.update.pilot");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setPilotUpdateParametres(pilot, preparedStatement);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	private void setPilotUpdateParametres(Pilot pilot, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, pilot.getStatus().toString());
		preparedStatement.setString(2, pilot.getFullName());
		preparedStatement.setInt(3, pilot.getId());
	}
}
