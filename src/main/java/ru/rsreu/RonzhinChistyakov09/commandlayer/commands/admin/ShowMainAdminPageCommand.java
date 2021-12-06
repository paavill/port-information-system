package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.MainAdminPageLogic;

public class ShowMainAdminPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		
		UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
		PierDao pierDao = (PierDao) request.getServletContext().getAttribute("pierDao");
		
		try {
			MainAdminPageLogic logic = new MainAdminPageLogic(pierDao, userDao);
			Collection<User> users = logic.getUsers();
			Collection<Pier> piers = logic.getPiers();
			request.setAttribute("usersData", users);
			request.setAttribute("piersData", piers);
			
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String page = "/jsp/adminMainPage.jsp";
		
		return new CommandResultResponseForward(page);
	}

}
