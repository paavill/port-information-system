package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * Interface provides access to model objects of the StatementStatus type
 * 
 * 
 * @author aleks
 *
 */
public interface StatementStatusDao {

	/**
	 * The method allows you to get statement status by title
	 * 
	 * @param title
	 * @return
	 * @throws DataRequestException
	 */
	StatementStatus getByTitle(String title) throws DataRequestException; 
	
}
