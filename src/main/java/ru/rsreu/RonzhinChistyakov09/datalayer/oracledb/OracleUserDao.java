package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.UserData;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.UserStatus;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OracleUserDao implements UserDao {
	private Connection connection;

	public OracleUserDao(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Collection<User> getAllUsers() throws DataRequestException{
		Collection<User> result = new ArrayList<User>();
		String query = Resourcer.getString("requests.sql.get.users.allUsers");
		try(Statement statement = this.connection.createStatement()) {
			try(ResultSet resultSet = statement.executeQuery(query)){
				while (resultSet.next()) {
					User user = getUserFromResultSet(resultSet);
					result.add(user);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(Resourcer.getString("exceptions.sql.request"));
		}
		return result;
	}
	
	private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
		UserData data = getUserDataFromResultSet(resultSet);
		int id = resultSet.getInt(Resourcer.getString("database.users.id"));
		String login = resultSet.getString(Resourcer.getString("database.users.login"));
		String password = resultSet.getString(Resourcer.getString("database.users.password"));
		UserStatus status = UserStatus.valueOf(resultSet.getString(Resourcer.getString("database.users.status")).trim());
		return new User(id, data, login, password, status);
	}
	
	private UserData getUserDataFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(Resourcer.getString("database.userData.id"));
		UserRole role = getUserRoleFromResultSet(resultSet);
		String passport = resultSet.getString(Resourcer.getString("database.userData.passport"));
		String fullName = resultSet.getString(Resourcer.getString("database.userData.fullName"));
		int age = resultSet.getInt(Resourcer.getString("database.userData.age"));
		return new UserData(id, role, passport, fullName, age);
	}
	
	private UserRole getUserRoleFromResultSet(ResultSet resultSet) throws SQLException {
//		UserRole role = UserRole.getById(resultSet.getInt("user_role_id"));
		UserRole role = UserRole.valueOf(resultSet.getString(Resourcer.getString("database.userRole.title")).trim());
		return role;
	}
}
