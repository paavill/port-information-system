package ru.rsreu.RonzhinChistyakov09.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.LogoutLogic;

public class SessionTimeoutListener implements HttpSessionListener {
	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		UserDao userDao = (UserDao) sessionEvent.getSession().getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.users"));
		UserStatusDao userStatusDao = (UserStatusDao) sessionEvent.getSession().getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.usersStatuses"));
		LogoutLogic logoutLogic = new LogoutLogic(userDao, userStatusDao);
		HttpSession session = sessionEvent.getSession();
		User user = (User) session.getAttribute(Resourcer.getString("servlet.session.attributes.user"));
		try {
			if (user != null) {
				logoutLogic.logout(user);
			}
		} catch (DataRequestException e) {
			System.out.println(e.getMessage());
		}
	}
}
