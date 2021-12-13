package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserStatusDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.DeleteUserLogic;

public class DeleteUserCommand implements ActionCommand {
	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		try {
			UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
			UserStatusDao userStatusDao = (UserStatusDao) request.getServletContext().getAttribute("userStatusDao");
			DeleteUserLogic logic = new DeleteUserLogic(userDao, userStatusDao);
			int userId = Integer.parseInt(request.getParameter("userIdToDelete"));
			logic.deleteUser(userId);
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}

}
