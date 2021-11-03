package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.Port;
import ru.rsreu.RonzhinChistyakov09.Tab;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;

public class ShowMainNoLoginPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = null;
		
		request.setAttribute("titleText", Resourcer.getString("jsp.main.noLogin.titleText"));
		request.setAttribute("logoText", Resourcer.getString("jsp.main.noLogin.logoText"));
		request.setAttribute("authorizationText", Resourcer.getString("jsp.main.noLogin.authorizationText"));
		request.setAttribute("aboutSystemText", Resourcer.getString("jsp.main.noLogin.aboutSystemText"));
		
		/**
		 * добавить в даошки  к пирсам и лоцманам
		 * количество лоцманов, количество свободных лоцманов
		 * количество пирсов, количество свободных присов
		 */
		Port port = new Port("PortName", 1, 1, 1, 1);
		request.setAttribute("aboutPortInformationText", Resourcer.getString("jsp.main.noLogin.aboutPortInformationText"));
		request.setAttribute("portData", port);
		request.setAttribute("piarCountText", Resourcer.getString("jsp.main.noLogin.piarCountText"));
		request.setAttribute("freePiarCountText", Resourcer.getString("jsp.main.noLogin.freePiarCountText"));
		request.setAttribute("pilotCountText", Resourcer.getString("jsp.main.noLogin.pilotCountText"));
		request.setAttribute("freePilotCountText", Resourcer.getString("jsp.main.noLogin.freePilotCountText"));
		/**
		 * тут будет юзаться dao, было бы неплохо еше в пирс добавить поле которое показывает
		 * его занятость: есть capacity, добавить остаточную вместимость
		 */
		Collection<Pier> piersData = new ArrayList<Pier>();
		
		piersData.add(new Pier(0, null, 1));
		request.setAttribute("aboutPiersInformationText", Resourcer.getString("jsp.main.noLogin.aboutPiersInformationText"));
		request.setAttribute("piersData", piersData);
		request.setAttribute("pierIdText", Resourcer.getString("jsp.main.noLogin.pierIdText"));
		request.setAttribute("pierStatusText", Resourcer.getString("jsp.main.noLogin.pierStatusText"));
		request.setAttribute("pierCapacityText", Resourcer.getString("jsp.main.noLogin.pierCapacityText"));
		
		page = Resourcer.getString("jsp.main.noLogin");

	
		return new CommandResultResponseForward(page);
	}
}
