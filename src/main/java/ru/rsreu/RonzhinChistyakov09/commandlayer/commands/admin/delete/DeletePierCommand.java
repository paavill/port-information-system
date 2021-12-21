package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.DeletePierLogic;

public class DeletePierCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		PierDao pierDao = (PierDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.piers"));
		DeletePierLogic logic = new DeletePierLogic(pierDao);
		int pierId = Integer
				.parseInt(request.getParameter(Resourcer.getString("servlet.requests.parametres.pierIdToDelete")));

		try {
			logic.deletePier(pierId);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}

		return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_ADMIN_PAGE");
	}
}
