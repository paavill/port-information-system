package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class ShowEditUserPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = "/jsp/editUserPage.jsp";
		
		Collection<UserRole> roles = new ArrayList<UserRole>();
		roles.add(new UserRole(0, "ADMINISTRATOR"));
		roles.add(new UserRole(1, "MODERATOR"));
		roles.add(new UserRole(2, "DISPATCHER"));
		roles.add(new UserRole(3, "CAPTAIN"));
		request.getSession().setAttribute("userRoles", roles);
		
		Collection<UserStatus> statuses = new ArrayList<UserStatus>();
		statuses.add(new UserStatus(0, "AUTHORIZED"));
		statuses.add(new UserStatus(1, "UNATHORIZED"));
		statuses.add(new UserStatus(2, "BLOCKED"));

		request.getSession().setAttribute("userStatuses", statuses);
		
		UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
		Integer userId = Integer.valueOf(request.getParameter("userIdToEdit"));
		User userToEdit = null;
		try {
			for(User user: userDao.getAllUsers()) {
				if(user.getId() == userId) {
					userToEdit = user;
					break;
				}
			}
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("userToEdit", userToEdit);
		request.setAttribute("selectedUserRole", userToEdit.getRole().getTitle());
		/*request.setAttribute("currentUserId", userToEdit.getId());
		request.setAttribute("currentUserStatus", userToEdit.getStatus());
		request.setAttribute("currentUserLogin", userToEdit.getLogin());
		request.setAttribute("currentUserPassword", userToEdit.getPassword());
		request.setAttribute("currentUserFullName", userToEdit.getFullName());
		*/
		return new CommandResultResponseForward(page);
	}

}
