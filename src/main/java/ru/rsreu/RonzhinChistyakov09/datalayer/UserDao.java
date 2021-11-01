package ru.rsreu.RonzhinChistyakov09.datalayer;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.User;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface UserDao {
	abstract Collection<User> getAllUsers() throws DataRequestException;
	
	abstract void createUser(User user) throws DataRequestException;
}
