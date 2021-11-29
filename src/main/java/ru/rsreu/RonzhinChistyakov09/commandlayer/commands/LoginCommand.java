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
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.logiclayer.LoginLogic;

public class LoginCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		System.out.println(login);
		System.out.println(password);
		
		try {
			DaoFactory factory = DaoFactory.getInstance(DBType.ORACLE);
			UserDao userDao = factory.getUserDao();
			LoginLogic logic = new LoginLogic(userDao);
			User user = logic.login(login, password);
			// Не знаю нужен ли тут юзер, если пароль не верный или юзера такого нет вылетит екзепшн
			System.out.println(user.toString());
			
			return new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE");
		} catch(Exception e) {
			System.out.println(e.toString());
			String page = Resourcer.getString("jsp.login");
			request.setAttribute("errorMessage", "fail to login");
			return new CommandResultResponseForward(page);
		}
	}
}
