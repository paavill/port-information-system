package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OracleStatementTypeDao implements StatementTypeDao {

	Connection connection;
	
	public OracleStatementTypeDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public StatementType getByTitle(String title) throws DataRequestException {
		StatementType type = null;
		String query = Resourcer.getString("requests.sql.get.statements.type.byTitle");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, title);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					type = ResultSetConverter.getStatementType(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return type;
	}

}
