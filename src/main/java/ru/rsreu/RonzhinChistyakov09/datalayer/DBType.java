package ru.rsreu.RonzhinChistyakov09.datalayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.oracledb.OracleDataBaseDaoFactory;

public enum DBType {
	ORACLE {
		@Override
		public DaoFactory getDAOFactory() throws Exception {
			return OracleDataBaseDaoFactory.getInstance();
		}
	};

	public abstract DaoFactory getDAOFactory() throws Exception;
}
