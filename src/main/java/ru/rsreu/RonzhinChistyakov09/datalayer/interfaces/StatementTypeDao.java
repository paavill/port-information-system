package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * Interface provides access to model objects of the StatementType type
 * 
 * @author aleks
 *
 */
public interface StatementTypeDao {

	/**
	 * Method allows you to get statement type by title
	 * 
	 * @param title
	 * @return
	 * @throws DataRequestException
	 */
	StatementType getByTitle(String title) throws DataRequestException;
	
}
