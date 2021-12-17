package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OracleStatementStatusDao implements StatementStatusDao {

	Connection connection;
	
	public OracleStatementStatusDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public StatementStatus getByTitle(String title) throws DataRequestException {
		StatementStatus status = null;
		String query = Resourcer.getString("requests.sql.get.statements.status.byTitle");
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			PreparedStatementParametresSetter.set(preparedStatement, title);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					status = ResultSetConverter.getStatementStatus(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return status;
	}

}
