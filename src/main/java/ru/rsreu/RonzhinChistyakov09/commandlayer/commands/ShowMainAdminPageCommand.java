package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class ShowMainAdminPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		
		UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
		PierDao pierDao = (PierDao) request.getServletContext().getAttribute("pierDao");
		
		try {
			request.setAttribute("usersData", userDao.getAllUsers());
			request.setAttribute("piersData", pierDao.getAllPiers());
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String page = "/jsp/adminMainPage.jsp";
		
		return new CommandResultResponseForward(page);
	}

}
