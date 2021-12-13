package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OracleUserStatusDao implements UserStatusDao {
	
	private Connection connection;
	
	public OracleUserStatusDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public UserStatus getUserStatusByTitle(String title) throws DataRequestException {
		UserStatus userStatus = null;
		String query = Resourcer.getString("requests.sql.get.users.status.byTitle");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, title);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					userStatus = ResultSetConverter.getUserStatus(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return userStatus;
	}

}
