package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;

public class OracleStatementDao implements StatementDao {
	
	private Connection connection;

	public OracleStatementDao(Connection connection) {
		this.connection = connection;
	}

}
