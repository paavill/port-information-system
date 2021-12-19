package ru.rsreu.RonzhinChistyakov09.logiclayer.getters;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class StatementTypeGetter {

	private final static String ENTER_TYPE_TITLE = Resourcer.getString("database.statements.types.enter");
	private final static String EXIT_TYPE_TITLE = Resourcer.getString("database.statements.types.exit");

	private final StatementTypeDao dao;

	public StatementTypeGetter(StatementTypeDao dao) {
		this.dao = dao;
	}

	public StatementType getEnterType() throws DataRequestException {
		return this.dao.getByTitle(ENTER_TYPE_TITLE);
	}

	public StatementType getExitType() throws DataRequestException {
		return this.dao.getByTitle(EXIT_TYPE_TITLE);
	}

}
