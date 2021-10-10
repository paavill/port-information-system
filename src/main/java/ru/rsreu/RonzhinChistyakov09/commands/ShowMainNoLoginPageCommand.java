package ru.rsreu.RonzhinChistyakov09.commands;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.Port;
import ru.rsreu.RonzhinChistyakov09.Tab;

public class ShowMainNoLoginPageCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		//тут будет использоваться dao
		Collection<Port> test = new ArrayList<Port>();
		test.add(new Port("PortName", 1, 1, 1, 1));

		Collection<Tab> testTabData = new ArrayList<Tab>();
		testTabData.add(new Tab("TestNameFromFC1", test));
		testTabData.add(new Tab("TestNameFromFC2", test));
		testTabData.add(new Tab("TestNameFromFC3", test));

		page = Resourcer.getString("jsp.main.noLogin");
		request.setAttribute("tabs", testTabData);

		return page;
	}

}
