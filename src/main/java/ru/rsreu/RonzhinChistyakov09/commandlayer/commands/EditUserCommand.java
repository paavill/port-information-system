package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.EditUserLogic;

public class EditUserCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			EditUserLogic logic = new EditUserLogic(userDao);
			int userId = Integer.parseInt(request.getParameter("currentUserId"));
			String login = (String)request.getParameter("currentUserLogin");
			String password = (String)request.getParameter("currentUserPassword");
			String fullName = (String)request.getParameter("currentUserFullName");
			Collection<UserRole> roles = (Collection<UserRole>)request.getSession().getAttribute("userRoles");
			Collection<UserStatus> statuses = (Collection<UserStatus>)request.getSession().getAttribute("userStatuses");
			String roleTitle = (String)request.getParameter("role");
			String statusTitle = (String)request.getParameter("currentUserStatus");
			UserRole userRole = null;
			UserStatus userStatus = null;
			// В юзер роли интересует только id
			if(roles != null) {
				for(UserRole role: roles) {
					if(role.getTitle().equals(roleTitle)) {
						userRole = role;
						break;
					}
				}
			}
			if(statuses != null) {
				for(UserStatus status: statuses) {
					if(status.getTitle().equals(statusTitle)) {
						userStatus = status;
						break;
					}
				}
			}
			logic.editUser(userId, new User(userId, login, password, fullName, userStatus, userRole));
			request.getSession().removeAttribute("userToEdit");
			request.getSession().removeAttribute("userStatuses");
			request.getSession().removeAttribute("userRoles");
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}

}
