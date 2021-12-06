package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OracleUserRoleDao implements UserRoleDao {
	private Connection connection;

	public OracleUserRoleDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Collection<UserRole> getUserRoles() throws DataRequestException {
		Collection<UserRole> result = new ArrayList<UserRole>();
		String query = Resourcer.getString("requests.sql.get.users.roles");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					UserRole userRole = ResultSetConverter.getUserRole(resultSet);
					result.add(userRole);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
	}

	@Override
	public UserRole getUserRoleByTitle(String title) throws DataRequestException {
		UserRole userRole = null;
		String query = Resourcer.getString("requests.sql.get.users.role.byTitle");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, title);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					userRole = ResultSetConverter.getUserRole(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return userRole;
	}
}
