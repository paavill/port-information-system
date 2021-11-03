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

public class ShowMainNoLoginPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = null;
	
		Collection<Port> test = new ArrayList<Port>();
		test.add(new Port("PortName", 1, 1, 1, 1));

		Collection<Tab> testTabData = new ArrayList<Tab>();
		
		testTabData.add(new Tab(Resourcer.getString("jsp.main.noLogin.aboutPortsInformationText"), test));
		request.setAttribute("titleText", Resourcer.getString("jsp.main.noLogin.titleText"));
		request.setAttribute("logoText", Resourcer.getString("jsp.main.noLogin.logoText"));
		request.setAttribute("authorizationText", Resourcer.getString("jsp.main.noLogin.authorizationText"));
		request.setAttribute("aboutSystemText", Resourcer.getString("jsp.main.noLogin.aboutSystemText"));
		page = Resourcer.getString("jsp.main.noLogin");
		request.setAttribute("tabs", testTabData);
	
		return new CommandResultResponseForward(page);
	}
}
