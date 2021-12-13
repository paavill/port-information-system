package ru.rsreu.RonzhinChistyakov09.datalayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;

public abstract class DaoFactory implements AutoCloseable {
	public static DaoFactory getInstance(DBType dbType) throws Exception {
		return dbType.getDAOFactory();
	}
	
	public abstract UserDao getUserDao();
	
	public abstract UserRoleDao getUserRoleDao();
	
	public abstract UserStatusDao getUserStatusDao();
	
	public abstract StatementDao getStatementDao();
	
	public abstract PierDao getPierDao();

	public abstract ShipDao getShipDao();
}
