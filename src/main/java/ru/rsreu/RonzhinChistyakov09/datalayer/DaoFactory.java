package ru.rsreu.RonzhinChistyakov09.datalayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PilotDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;

public abstract class DaoFactory implements AutoCloseable {
	public static DaoFactory getInstance(DBType dbType) throws Exception {
		return dbType.getDAOFactory();
	}
	
	public abstract UserDao getUserDao();
	
	public abstract StatementDao getStatementDao();
	
	public abstract PierDao getPierDao();
	
	public abstract PilotDao getPilotDao();
}
