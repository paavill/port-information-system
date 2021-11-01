package ru.rsreu.RonzhinChistyakov09.datalayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.oracledb.OracleUsersDao;

public abstract class DAOFactory implements AutoCloseable {
	public static DAOFactory getInstance(DBType dbType) throws Exception {
		return dbType.getDAOFactory();
	}
	
	public abstract OracleUsersDao getUsersDao();
}
