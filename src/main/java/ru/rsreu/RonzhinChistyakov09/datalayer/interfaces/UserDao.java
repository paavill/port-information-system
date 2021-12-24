package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * Interface provides access to model objects of the User type
 * 
 * @author aleksej
 *
 */
public interface UserDao {
	/**
	 * 
	 * @return all unremoved users on the system
	 * @throws DataRequestException
	 */
	Collection<User> getAllUsers() throws DataRequestException;

	/**
	 * The method allows you to get users of a certain role
	 * 
	 * @param roleId
	 * @return all unremoved users of this role
	 * @throws DataRequestException
	 */
	Collection<User> getUsersByRoleId(int roleId) throws DataRequestException;

	/**
	 * Method allows you to get user by login
	 * 
	 * @param login
	 * @return
	 * @throws DataRequestException
	 */
	User getUserByLogin(String login) throws DataRequestException;

	/**
	 * Method allows you to get user by id
	 * 
	 * @param id
	 * @return
	 * @throws DataRequestException
	 */
	User getUserById(int id) throws DataRequestException;

	/**
	 * 
	 * @return highest user id
	 * @throws DataRequestException
	 */
	int getLastUserId() throws DataRequestException;

	/**
	 * Method allows you to create user
	 * 
	 * @param user
	 * @throws DataRequestException
	 */
	void createUser(User user) throws DataRequestException;

	/**
	 * Method allows you to update user
	 * 
	 * @param user
	 * @throws DataRequestException
	 */
	void updateUser(User user) throws DataRequestException;

	/**
	 * Method allows you to remove user
	 * 
	 * @param id
	 * @throws DataRequestException
	 */
	void deleteUser(int id) throws DataRequestException;

	/**
	 * 
	 * @return id of all users with the status of captain without a ship
	 * @throws DataRequestException
	 */
	Collection<Integer> getCaptainsWithoutShipIds() throws DataRequestException;

	/**
	 * The method allows you to get users of of a certain status
	 * 
	 * @param statusId
	 * @return
	 * @throws DataRequestException
	 */
	Collection<User> getUsersByStatusId(int statusId) throws DataRequestException;

	/**
	 * 
	 * @return all unblocked and deleted users
	 * @throws DataRequestException
	 */
	Collection<User> getActiveUsers() throws DataRequestException;
}
