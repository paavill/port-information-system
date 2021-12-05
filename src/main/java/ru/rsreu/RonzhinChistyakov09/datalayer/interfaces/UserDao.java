package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
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
	
	abstract Ship getUserShip(int userId) throws DataRequestException;
	
	abstract void createShip(int userId, Ship ship) throws DataRequestException;
	
	abstract Collection<UserRole> getUserRoles() throws DataRequestException;

	abstract UserRole getUserRoleByTitle(String title) throws DataRequestException;
}
