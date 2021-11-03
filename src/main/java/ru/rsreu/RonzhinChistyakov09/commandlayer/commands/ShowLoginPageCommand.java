package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;

public class ShowLoginPageCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String page = null;
		page = Resourcer.getString("jsp.login");
		request.setAttribute("logoText", Resourcer.getString("jsp.login.logoText"));
		request.setAttribute("authorizationText", Resourcer.getString("jsp.login.authorizationText"));
		request.setAttribute("loginText", Resourcer.getString("jsp.login.loginText"));
		request.setAttribute("placeholderLoginText", Resourcer.getString("jsp.login.placeholderLoginText"));
		request.setAttribute("passwordText", Resourcer.getString("jsp.login.passwordText"));
		request.setAttribute("placeholderPasswordText", Resourcer.getString("jsp.login.placeholderPasswordText"));
		request.setAttribute("enterButtonText", Resourcer.getString("jsp.login.enterButtonText"));
		request.setAttribute("cancelButtonText", Resourcer.getString("jsp.login.cancelButtonText"));
		return new CommandResultResponseForward(page);
	}

}
