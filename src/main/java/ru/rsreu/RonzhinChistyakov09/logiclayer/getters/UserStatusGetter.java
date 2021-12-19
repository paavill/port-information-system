package ru.rsreu.RonzhinChistyakov09.logiclayer.getters;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class UserStatusGetter {

	private final static String BLOCKED_STATUS_TITLE = Resourcer.getString("database.users.statuses.blocked");
	private final static String ONLINE_STATUS_TITLE = Resourcer.getString("database.users.statuses.online");
	private final static String OFFLINE_STATUS_TITLE = Resourcer.getString("database.users.statuses.offline");
	private final static String DELETED_STATUS_TITLE = Resourcer.getString("database.users.statuses.deleted");

	private final UserStatusDao dao;

	public UserStatusGetter(UserStatusDao dao) {
		this.dao = dao;
	}

	public UserStatus getOnlineStatus() throws DataRequestException {
		return dao.getUserStatusByTitle(ONLINE_STATUS_TITLE);
	}

	public UserStatus getOfflineStatus() throws DataRequestException {
		return dao.getUserStatusByTitle(OFFLINE_STATUS_TITLE);
	}

	public UserStatus getBlockStatus() throws DataRequestException {
		return dao.getUserStatusByTitle(BLOCKED_STATUS_TITLE);
	}

	public UserStatus getDeleteStatus() throws DataRequestException {
		return dao.getUserStatusByTitle(DELETED_STATUS_TITLE);
	}

}
