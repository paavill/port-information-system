package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.InvalidValue;
import ru.rsreu.RonzhinChistyakov09.logiclayer.admin.CreatePierLogic;

public class CreatePierCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) throws DataRequestException {
		PierDao pierDao = (PierDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.piers"));
		CreatePierLogic logic = new CreatePierLogic(pierDao);
		int capacity = Integer
				.parseInt(request.getParameter(Resourcer.getString("servlet.requests.patametres.pier.capacity")));
		try {
			logic.createPier(capacity);
		} catch (InvalidValue e) {
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.errorMessage"), String
					.format(Resourcer.getString("exceptions.captain.create.pier.capacity"), String.valueOf(capacity)));
			return new CommandResultResponseForward(Resourcer.getString("jsp.admin.createPier"));
		}
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.admin"));
	}

}
