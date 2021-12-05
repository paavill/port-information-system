package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.DeletePierLogic;

public class DeletePierCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {

		try {
			PierDao pierDao = (PierDao) request.getServletContext().getAttribute("pierDao");
			DeletePierLogic logic = new DeletePierLogic(pierDao);
			int pierId = Integer.parseInt(request.getParameter("pierIdToDelete"));
			logic.deletePier(pierId);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}

		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}
}
