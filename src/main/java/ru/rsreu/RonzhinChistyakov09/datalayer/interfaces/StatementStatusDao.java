package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface StatementStatusDao {

	abstract StatementStatus getByTitle(String title) throws DataRequestException; 
	
}
