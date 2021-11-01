package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.Chistyakov0818.exceptions.StorageException;
import ru.rsreu.RonzhinChistyakov09.datalayer.DaoFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.UserDao;

public class OracleDataBaseDaoFactory extends DaoFactory {
	private static volatile OracleDataBaseDaoFactory instance;

	private Connection connection;

	private OracleDataBaseDaoFactory() {
	}

	public static OracleDataBaseDaoFactory getInstance() throws SQLException {
		OracleDataBaseDaoFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDataBaseDaoFactory.class) {
				factory = new OracleDataBaseDaoFactory();
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
	public UserDao getUserDao() {
		return new OracleUserDao(this.connection);
	}
	
	@Override
	public void close() throws Exception {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new StorageException(Resourcer.getString("exceptions.sql.disconnect"));
			}
		}
	}
}
