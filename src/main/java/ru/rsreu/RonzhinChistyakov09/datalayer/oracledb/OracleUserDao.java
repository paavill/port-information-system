package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserData;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OracleUserDao implements UserDao {
	private Connection connection;

	public OracleUserDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Collection<User> getAllUsers() throws DataRequestException {
		Collection<User> result = new ArrayList<User>();
		String query = Resourcer.getString("requests.sql.get.users.allUsers");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					User user = getUserFromResultSet(resultSet);
					result.add(user);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
	}
	
	@Override
	public User getByLogin(String login) throws DataRequestException {
		User user = null;
		String query = Resourcer.getString("requests.sql.get.user.byLogin");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, login);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					return getUserFromResultSet(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return user;
	}

	private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
		UserData data = getUserDataFromResultSet(resultSet);
		int id = resultSet.getInt(Resourcer.getString("database.users.id"));
		String login = resultSet.getString(Resourcer.getString("database.users.login"));
		String password = resultSet.getString(Resourcer.getString("database.users.password"));
		UserStatus status = UserStatus
				.valueOf(resultSet.getString(Resourcer.getString("database.users.status")).trim());
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

	@Override
	public void createUser(User user) throws DataRequestException {
		String createUserDataQuery = Resourcer.getString("requests.sql.create.userData");
		try (PreparedStatement createDataPreparedStatement = connection.prepareStatement(createUserDataQuery)) {
			UserData data = user.getData();
			setUserDataParametresOnPreparedStatement(data, createDataPreparedStatement);
			createDataPreparedStatement.executeQuery();
			String createUserQuery = Resourcer.getString("requests.sql.create.user");
			try (PreparedStatement createUserPreparedStatement = connection.prepareStatement(createUserQuery)) {
				setUserParametresOnPreparedStatement(user, createUserPreparedStatement);
				createUserPreparedStatement.executeQuery();
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	private void setUserDataParametresOnPreparedStatement(UserData data, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setInt(1, data.getId());
		preparedStatement.setInt(2, data.getRole().ordinal());
		preparedStatement.setString(3, data.getPassportNumber());
		preparedStatement.setString(4, data.getFullName());
		preparedStatement.setInt(5, data.getAge());
	}

	private void setUserParametresOnPreparedStatement(User user, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setInt(1, user.getId());
		UserData data = user.getData();
		preparedStatement.setInt(2, data.getId());
		preparedStatement.setString(3, user.getLogin());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getStatus().toString());
	}

	@Override
	public int getUsersCount() throws DataRequestException {
		int usersCount = 0;
		String query = Resourcer.getString("requests.sql.get.users.count");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					usersCount = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return usersCount;
	}

	@Override
	public void updateUser(User user) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.update.user");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setUserUpdateParametres(user, preparedStatement);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}
	
	public void setUserUpdateParametres(User user, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, user.getLogin());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getStatus().toString());
		preparedStatement.setInt(4, user.getId());
	}

	@Override
	public void updateUserData(UserData userData) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.update.userData");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setUserDataUpdateParametres(userData, preparedStatement);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}
	
	public void setUserDataUpdateParametres(UserData data, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, data.getRole().ordinal());
		preparedStatement.setString(2, data.getPassportNumber());
		preparedStatement.setString(3, data.getFullName());
		preparedStatement.setInt(4, data.getAge());
		preparedStatement.setInt(5, data.getId());
	}
}
