package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * Interface provides access to model objects of the UserRole type
 * 
 * @author aleks
 *
 */
public interface UserRoleDao {
	/**
	 * 
	 * @return all user roles
	 * @throws DataRequestException
	 */
	Collection<UserRole> getUserRoles() throws DataRequestException;

	/**
	 * The method allows you to get user role by title
	 * 
	 * @param title
	 * @return
	 * @throws DataRequestException
	 */
	UserRole getUserRoleByTitle(String title) throws DataRequestException;
}
