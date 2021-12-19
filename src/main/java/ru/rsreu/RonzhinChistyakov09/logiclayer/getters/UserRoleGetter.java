package ru.rsreu.RonzhinChistyakov09.logiclayer.getters;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserRoleDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class UserRoleGetter {

	private final static String ADMINISTRATOR_ROLE_TITLE = Resourcer.getString("database.users.roles.administrator");
	private final static String MODERATOR_ROLE_TITLE = Resourcer.getString("database.users.roles.moderator");
	private final static String DISPATCHER_ROLE_TITLE = Resourcer.getString("database.users.roles.dispatcher");
	private final static String CAPTAIN_ROLE_TITLE = Resourcer.getString("database.users.roles.captain");

	private final UserRoleDao dao;

	public UserRoleGetter(UserRoleDao dao) {
		this.dao = dao;
	}

	public UserRole getAdministratorRole() throws DataRequestException {
		return this.dao.getUserRoleByTitle(ADMINISTRATOR_ROLE_TITLE);
	}

	public UserRole getModeratorRole() throws DataRequestException {
		return this.dao.getUserRoleByTitle(MODERATOR_ROLE_TITLE);
	}

	public UserRole getDispatcherRole() throws DataRequestException {
		return this.dao.getUserRoleByTitle(DISPATCHER_ROLE_TITLE);
	}

	public UserRole getCaptainRole() throws DataRequestException {
		return this.dao.getUserRoleByTitle(CAPTAIN_ROLE_TITLE);
	}

}
