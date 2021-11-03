package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.ArrayList;
import java.util.Collection;

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
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.PierStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PilotDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;

public class ShowMainNoLoginPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = null;
		
		request.setAttribute("titleText", Resourcer.getString("jsp.main.noLogin.titleText"));
		request.setAttribute("logoText", Resourcer.getString("jsp.main.noLogin.logoText"));
		request.setAttribute("authorizationText", Resourcer.getString("jsp.main.noLogin.authorizationText"));
		request.setAttribute("aboutSystemText", Resourcer.getString("jsp.main.noLogin.aboutSystemText"));
		
		
		Port port = null;
		Collection<Pier> piersData = new ArrayList<Pier>();
		try {
			DaoFactory factory = DaoFactory.getInstance(DBType.ORACLE);
			PierDao pierDao = factory.getPierDao();
			int piersCount = pierDao.getPiersCount();
			int freePiersCount = pierDao.getFreePiersCount();
			PilotDao pilotDao = factory.getPilotDao();
			int pilotsCount = pilotDao.getPilotsCount();
			int freePilotsCount = pilotDao.getFreePilotsCount();
			port = new Port("PortName", piersCount, freePiersCount, pilotsCount, freePilotsCount);
			Pier pier = new Pier(1, PierStatus.FILLED, 20);
			pierDao.updatePier(pier);
			piersData = pierDao.getAllPiers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("aboutPortInformationText", Resourcer.getString("jsp.main.noLogin.aboutPortInformationText"));
		request.setAttribute("portData", port);
		request.setAttribute("piarCountText", Resourcer.getString("jsp.main.noLogin.piarCountText"));
		request.setAttribute("freePiarCountText", Resourcer.getString("jsp.main.noLogin.freePiarCountText"));
		request.setAttribute("pilotCountText", Resourcer.getString("jsp.main.noLogin.pilotCountText"));
		request.setAttribute("freePilotCountText", Resourcer.getString("jsp.main.noLogin.freePilotCountText"));
		request.setAttribute("aboutPiersInformationText", Resourcer.getString("jsp.main.noLogin.aboutPiersInformationText"));
		request.setAttribute("piersData", piersData);
		request.setAttribute("pierIdText", Resourcer.getString("jsp.main.noLogin.pierIdText"));
		request.setAttribute("pierStatusText", Resourcer.getString("jsp.main.noLogin.pierStatusText"));
		request.setAttribute("pierCapacityText", Resourcer.getString("jsp.main.noLogin.pierCapacityText"));
		
		page = Resourcer.getString("jsp.main.noLogin");

	
		return new CommandResultResponseForward(page);
	}
}
