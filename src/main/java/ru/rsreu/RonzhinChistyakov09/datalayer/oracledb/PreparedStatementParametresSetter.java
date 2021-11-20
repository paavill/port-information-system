package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementParametresSetter {

	private PreparedStatementParametresSetter() {
		
	}

	public static void set(PreparedStatement preparedStatement, Object... args)
			throws SQLException {
		for (int i = 0; i < args.length; i++) {
			preparedStatement.setString(i + 1, String.valueOf(args[i]));
		}
	}
}
