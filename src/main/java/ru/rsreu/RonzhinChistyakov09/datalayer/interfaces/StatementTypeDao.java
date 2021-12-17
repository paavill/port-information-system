package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface StatementTypeDao {

	abstract StatementType getByTitle(String title) throws DataRequestException;
	
}
