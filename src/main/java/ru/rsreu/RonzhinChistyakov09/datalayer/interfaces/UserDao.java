package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface UserDao {
	abstract Collection<User> getAllUsers() throws DataRequestException;
	
	abstract User getUserByLogin(String login) throws DataRequestException;
	
	abstract User getUserById(int id) throws DataRequestException;
	
	abstract int getUsersCount() throws DataRequestException;
	
	abstract int getLastUserId() throws DataRequestException;
	
	abstract void createUser(User user) throws DataRequestException;
	
	abstract void updateUser(User user) throws DataRequestException;
	
	abstract void deleteUser(int id) throws DataRequestException;

	abstract Collection<Integer> getCaptainsId() throws DataRequestException;
	
	abstract Collection<User> getUsersByStatusId(int statusId) throws DataRequestException;
}
