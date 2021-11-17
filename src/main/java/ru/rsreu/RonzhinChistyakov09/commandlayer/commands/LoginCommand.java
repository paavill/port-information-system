package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.DBType;
import ru.rsreu.RonzhinChistyakov09.datalayer.DaoFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;

public class LoginCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		boolean loginLogicResult = false;
		ICommandResult result = null;
		if (loginLogicResult) {
			// здесь SHOW_MAIN_NO_LOGIN_PAGE пока что, НО в зависимости от того, что
			// произойдет в логике
			// будет браться другая команда (команда показать другую страницу), то есть
			// будет редирект после логина на страницу
			// пользователя в зависимости от его роли
			// также тут будет логика изменения статуса в бд
			System.out.println("OK!");
			result = new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE");
		} else {
			String page = Resourcer.getString("jsp.login");
			request.setAttribute("errorMessage", "fail to login");
			result = new CommandResultResponseForward(page);
		}
		return result;
	}
}
