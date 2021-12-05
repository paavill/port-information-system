package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;

public class ShowCreateUserPageCommand implements ICommand {
	
	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = "/jsp/createUserPage.jsp";
		
		Collection<UserRole> roles = new ArrayList<UserRole>();
		roles.add(new UserRole(0, "ADMINISTRATOR"));
		roles.add(new UserRole(1, "MODERATOR"));
		roles.add(new UserRole(2, "DISPATCHER"));
		roles.add(new UserRole(3, "CAPTAIN"));
		
		request.getSession().setAttribute("userRoles", roles);
		
		return new CommandResultResponseForward(page);
	}

}
