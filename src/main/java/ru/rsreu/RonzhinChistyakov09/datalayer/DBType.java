package ru.rsreu.RonzhinChistyakov09.datalayer;

import ru.rsreu.RonzhinChistyakov09.datalayer.oracledb.OracleDataBaseDAOFactory;

public enum DBType {
	ORACLE {
		@Override
		public DAOFactory getDAOFactory() throws Exception {
			return OracleDataBaseDAOFactory.getInstance();
		}
	};

	public abstract DAOFactory getDAOFactory() throws Exception;
}
