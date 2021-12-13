package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface UserStatusDao {
	abstract UserStatus getUserStatusByTitle(String title) throws DataRequestException;
}
