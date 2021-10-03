package ru.rsreu.RonzhinChistyakov09.datalayer;

public abstract class DAOFactory implements AutoCloseable {
	public static DAOFactory getInstance(DBType dbType) throws Exception {
		return dbType.getDAOFactory();
	}
}
