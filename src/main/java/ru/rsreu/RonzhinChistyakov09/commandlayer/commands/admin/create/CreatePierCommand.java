package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.CreatePierLogic;

public class CreatePierCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		try {
			PierDao pierDao = (PierDao) request.getServletContext().getAttribute("pierDao");
			CreatePierLogic logic = new CreatePierLogic(pierDao);
			int capacity = Integer.parseInt(request.getParameter("pierCapacity"));
			logic.createPier(capacity);
		} catch (DataRequestException e) {

		}
		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}

}
