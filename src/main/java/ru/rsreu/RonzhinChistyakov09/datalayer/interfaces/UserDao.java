package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserData;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface UserDao {
	abstract Collection<User> getAllUsers() throws DataRequestException;
	
	abstract User getByLogin(String login) throws DataRequestException;
	
	abstract void createUser(User user) throws DataRequestException;
	
	abstract int getUsersCount() throws DataRequestException;
	
	abstract void updateUser(User user) throws DataRequestException;
	
	abstract void updateUserData(UserData userData) throws DataRequestException;
}
