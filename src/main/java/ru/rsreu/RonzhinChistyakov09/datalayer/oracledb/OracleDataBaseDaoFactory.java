package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.DaoFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.StorageException;

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
	public UserRoleDao getUserRoleDao() {
		return new OracleUserRoleDao(this.connection);
	}
	
	@Override
	public UserStatusDao getUserStatusDao() {
		return new OracleUserStatusDao(this.connection);
	}

	@Override
	public StatementDao getStatementDao() {
		return new OracleStatementDao(this.connection);
	}
	

	@Override
	public StatementTypeDao getStatementTypeDao() {
		return new OracleStatementTypeDao(this.connection);
	}
	

	@Override
	public StatementStatusDao getStatementStatusDao() {
		return new OracleStatementStatusDao(this.connection);
	}

	@Override
	public PierDao getPierDao() {
		return new OraclePierDao(this.connection);
	}


	@Override
	public ShipDao getShipDao() {
		return new OracleShipDao(this.connection);
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
