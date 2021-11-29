package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.CollectionToTableFormatter;
import ru.rsreu.RonzhinChistyakov09.Port;
import ru.rsreu.RonzhinChistyakov09.Tab;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.DBType;
import ru.rsreu.RonzhinChistyakov09.datalayer.DaoFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.logiclayer.MainPageLogic;

public class ShowMainNoLoginPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = null;
		Port port = null;
		Collection<Pier> piersData = new ArrayList<Pier>();
		try {
			DaoFactory factory = DaoFactory.getInstance(DBType.ORACLE);
			PierDao pierDao = factory.getPierDao();
			// Не знаю как дао в логику передавать, пока так оставлю
			MainPageLogic logic = new MainPageLogic(pierDao);
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
