package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface UserRoleDao {
	abstract Collection<UserRole> getUserRoles() throws DataRequestException;

	abstract UserRole getUserRoleByTitle(String title) throws DataRequestException;
}
