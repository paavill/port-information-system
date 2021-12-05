package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.Port;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.logiclayer.MainNoLoginPageLogic;

public class ShowMainNoLoginPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = null;
		Port port = null;
		Collection<Pier> piersData = new ArrayList<Pier>();
		try {
			PierDao pierDao = (PierDao) request.getServletContext().getAttribute("pierDao");
			MainNoLoginPageLogic logic = new MainNoLoginPageLogic(pierDao);
			port = logic.getPort();
			piersData = logic.getPiers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("portData", port);
		request.setAttribute("piersData", piersData);

		page = Resourcer.getString("jsp.main.noLogin");
		return new CommandResultResponseForward(page);
	}
}
