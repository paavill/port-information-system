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
	

	private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(Resourcer.getString("database.users.id"));
		String login = resultSet.getString(Resourcer.getString("database.users.login"));
		String password = resultSet.getString(Resourcer.getString("database.users.password"));
		String fullName = resultSet.getString(Resourcer.getString("database.users.fullName"));
		UserStatus status = new UserStatus(resultSet.getInt(Resourcer.getString("database.users.statusId")), 
				resultSet.getString(Resourcer.getString("database.users.statusTitle")));
		UserRole role = new UserRole(resultSet.getInt(Resourcer.getString("database.users.roleId")), 
				resultSet.getString(Resourcer.getString("database.users.roleTitle")));
		return new User(id, login, password, fullName, status, role);
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

	// FIX
	@Override
	public void createUser(User user) throws DataRequestException {
		String createUserDataQuery = Resourcer.getString("requests.sql.create.userData");
		try (PreparedStatement createDataPreparedStatement = connection.prepareStatement(createUserDataQuery)) {
			
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

	// FIX
	private void setUserParametresOnPreparedStatement(User user, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getLogin());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getStatus().toString());
	}

	// FIX
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

	// FIX
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

	private void setUserUpdateParametres(User user, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, user.getLogin());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getStatus().toString());
		preparedStatement.setInt(4, user.getId());
	}
}
