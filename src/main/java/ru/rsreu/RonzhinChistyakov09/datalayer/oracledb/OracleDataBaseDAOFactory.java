package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.DAOFactory;

public class OracleDataBaseDAOFactory extends DAOFactory {
	private static volatile OracleDataBaseDAOFactory instance;

	private Connection connection;

	private OracleDataBaseDAOFactory() {
	}

	public static OracleDataBaseDAOFactory getInstance() throws SQLException {
		OracleDataBaseDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDataBaseDAOFactory.class) {
				factory = new OracleDataBaseDAOFactory();
				instance = factory;
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws SQLException {
		String url = Resourcer.getString("database.oracle.config.url");
		String user = Resourcer.getString("database.oracle.config.user");
		String password = Resourcer.getString("database.oracle.config.password");
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			this.connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new SQLException(
					String.format(Resourcer.getString("database.oracle.connected.fail"), e.getMessage()));
		}
	}
	
	@Override
	public void close() throws Exception {
		this.connection.close();
	}
	
	
}
