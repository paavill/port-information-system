package ru.rsreu.RonzhinChistyakov09.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

public class ShowLoginPageCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = Resourcer.getString("jsp.login");
		return page;
	}

}
