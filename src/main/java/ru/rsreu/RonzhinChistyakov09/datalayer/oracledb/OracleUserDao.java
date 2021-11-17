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
		UserStatus status = getUserStatusFromResultSet(resultSet);
		UserRole role = getUserRoleFromResultSet(resultSet);
		return new User(id, login, password, fullName, status, role);
	}
	
	private UserStatus getUserStatusFromResultSet(ResultSet resultSet) throws SQLException {
		return  new UserStatus(resultSet.getInt(Resourcer.getString("database.users.statusId")), 
				resultSet.getString(Resourcer.getString("database.users.statusTitle")));
	}
	
	private UserRole getUserRoleFromResultSet(ResultSet resultSet) throws SQLException {
		return new UserRole(resultSet.getInt(Resourcer.getString("database.users.roleId")), 
				resultSet.getString(Resourcer.getString("database.users.roleTitle")));
	}

	@Override
	public User getByLogin(String login) throws DataRequestException {
		User user = null;
		String query = Resourcer.getString("requests.sql.get.user.byLogin");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, login);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					user = getUserFromResultSet(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return user;
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
	public void createUser(User user) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.create.user");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setUserParametresOnPreparedStatement(user, preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	private void setUserParametresOnPreparedStatement(User user, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getLogin());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getFullName());
		preparedStatement.setInt(5, user.getStatus().getId());
		preparedStatement.setInt(6, user.getRole().getId());
	}

	@Override
	public void updateUser(int userId, User user) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.update.user");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 setUserParametresOnPreparedStatement(user, preparedStatement);
			 preparedStatement.setInt(7, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}
}
