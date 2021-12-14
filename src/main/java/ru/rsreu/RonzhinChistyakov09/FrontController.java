package ru.rsreu.RonzhinChistyakov09;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandFactory;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.DBType;
import ru.rsreu.RonzhinChistyakov09.datalayer.DaoFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.logiclayer.moderator.BlockUserLogic;
import ru.rsreu.RonzhinChistyakov09.logiclayer.moderator.MainModeratorPageLogic;
import ru.rsreu.RonzhinChistyakov09.logiclayer.moderator.UnblockUserLogic;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 3363040659143078486L;

	public FrontController() {
		super();
	}

	public void init() throws ServletException {
		Locale.setDefault(Locale.US);
		try {
			DaoFactory factory = DaoFactory.getInstance(DBType.ORACLE);
			ServletContext context = this.getServletContext();
			context.setAttribute("userDao", factory.getUserDao());
			context.setAttribute("userRoleDao", factory.getUserRoleDao());
			context.setAttribute("userStatusDao", factory.getUserStatusDao());
			context.setAttribute("pierDao", factory.getPierDao());
			context.setAttribute("shipDao", factory.getShipDao());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionCommand command = CommandFactory.getCommand(request);

		ActionCommandResult commandExecutionResult = command.execute(request);

		commandExecutionResult.toResponse(getServletContext(), request, response);
	}

	public void destroy() {
		super.destroy();
	}
}
