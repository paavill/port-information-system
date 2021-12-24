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
					User user = ResultSetConverter.getUser(resultSet);
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
	public Collection<User> getUsersByRoleId(int roleId) throws DataRequestException {
		Collection<User> result = new ArrayList<User>();
		String query = Resourcer.getString("requests.sql.get.users.byRole");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, roleId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					User user = ResultSetConverter.getUser(resultSet);
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
	public User getUserById(int id) throws DataRequestException {
		User user = null;
		String query = Resourcer.getString("requests.sql.get.user.byId");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					user = ResultSetConverter.getUser(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return user;
	}

	@Override
	public User getUserByLogin(String login) throws DataRequestException {
		User user = null;
		String query = Resourcer.getString("requests.sql.get.user.byLogin");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, login);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					user = ResultSetConverter.getUser(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return user;
	}

//	@Override
//	public int getUsersCount() throws DataRequestException {
//		int usersCount = 0;
//		String query = Resourcer.getString("requests.sql.get.users.count");
//		try (Statement statement = this.connection.createStatement()) {
//			try (ResultSet resultSet = statement.executeQuery(query)) {
//				if (resultSet.next()) {
//					usersCount = resultSet.getInt(1);
//				}
//			}
//		} catch (SQLException e) {
//			throw new DataRequestException(
//					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
//		}
//		return usersCount;
//	}

	@Override
	public int getLastUserId() throws DataRequestException {
		int lastUserId = 0;
		String query = Resourcer.getString("requests.sql.get.users.lastId");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				if (resultSet.next()) {
					lastUserId = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return lastUserId;
	}

	@Override
	public void createUser(User user) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.create.user");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, user.getId(), user.getLogin(), user.getPassword(),
					user.getFullName(), user.getStatus().getId(), user.getRole().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	@Override
	public void updateUser(User user) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.update.user");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, user.getLogin(), user.getPassword(),
					user.getFullName(), user.getStatus().getId(), user.getRole().getId(), user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	@Override
	public void deleteUser(int id) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.delete.user");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}
	
	@Override
	public Collection<Integer> getCaptainsWithoutShipIds() throws DataRequestException{
		Collection<Integer> result = new ArrayList<Integer>();
		String query = Resourcer.getString("requests.sql.get.users.captains.id");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					result.add(resultSet.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
		
	}

	@Override
	public Collection<User> getUsersByStatusId(int statusId) throws DataRequestException {
		Collection<User> result = new ArrayList<User>();
		String query = Resourcer.getString("requests.sql.get.users.byStatus");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, statusId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					User user = ResultSetConverter.getUser(resultSet);
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
	public Collection<User> getActiveUsers() throws DataRequestException {
		Collection<User> result = new ArrayList<User>();
		String query = Resourcer.getString("requests.sql.get.users.active");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					User user = ResultSetConverter.getUser(resultSet);
					result.add(user);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
	}
}
