package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * Interface provides access to model objects of the UserStatus type
 * 
 * @author aleks
 *
 */
public interface UserStatusDao {
	/**
	 * The method allows you to get status by title
	 * 
	 * @param title
	 * @return
	 * @throws DataRequestException
	 */
	UserStatus getUserStatusByTitle(String title) throws DataRequestException;
}
