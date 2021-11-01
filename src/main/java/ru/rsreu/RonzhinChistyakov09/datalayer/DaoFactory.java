package ru.rsreu.RonzhinChistyakov09.datalayer;

public abstract class DaoFactory implements AutoCloseable {
	public static DaoFactory getInstance(DBType dbType) throws Exception {
		return dbType.getDAOFactory();
	}
	
	public abstract UserDao getUserDao();
}
