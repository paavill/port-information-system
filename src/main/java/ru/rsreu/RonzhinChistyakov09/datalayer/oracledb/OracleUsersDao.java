package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.User;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;


//TODO: make an interface to inherit from thhis class 
public class OracleUsersDao {
	private Connection connection;

	private static final int FIRST_COLUMN_NUMBER = 1;
	private static final int SECOND_COLUMN_NUMBER = 2;
	private static final int THIRD_COLUMN_NUMBER = 3;
	private static final int FOURTH_COLUMN_NUMBER = 4;
	private static final int FIFTH_COLUMN_NUMBER = 5;
	private static final int SIXTH_COLUMN_NUMBER = 6;

	public OracleUsersDao(Connection connection) {
		this.connection = connection;
	}
	
	public Collection<User> getAllUsers() throws DataRequestException{
		Collection<User> result = new ArrayList<User>();
		String query = Resourcer.getString("requests.sql.get.users.allUsers");
		Statement statement = null;
		try {
			statement = this.connection.createStatement();
			boolean executeResult = statement.execute(query);
			if (executeResult) {
				ResultSet resultSet = statement.getResultSet();
				while (resultSet.next()) {
					User user = new User(resultSet.getInt(FIRST_COLUMN_NUMBER), resultSet.getInt(SECOND_COLUMN_NUMBER),
							resultSet.getInt(THIRD_COLUMN_NUMBER), resultSet.getString(FOURTH_COLUMN_NUMBER),
							resultSet.getString(FIFTH_COLUMN_NUMBER), resultSet.getString(SIXTH_COLUMN_NUMBER));
					result.add(user);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(Resourcer.getString("exceptions.sql.request"));
		}
		return result;
	}

}
