package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.logiclayer.MainNoLoginPageLogic;

public class ShowMainNoLoginPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		try {
			PierDao pierDao = (PierDao) request.getServletContext()
					.getAttribute(Resourcer.getString("serlvet.context.dao.piers"));
			MainNoLoginPageLogic logic = new MainNoLoginPageLogic(pierDao);
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.port"), logic.getPort());
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.piers"), logic.getPiers());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String page = Resourcer.getString("jsp.main.noLogin");
		return new CommandResultResponseForward(page);
	}
}
