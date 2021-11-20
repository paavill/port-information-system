package ru.rsreu.RonzhinChistyakov09;

import java.io.IOException;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandFactory;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.DBType;
import ru.rsreu.RonzhinChistyakov09.datalayer.DaoFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.Ship;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 3363040659143078486L;

	public FrontController() {
		super();
	}

	public void init() throws ServletException {
		Locale.setDefault(Locale.US);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
		System.out.println("get");
		try {
			DaoFactory factory = DaoFactory.getInstance(DBType.ORACLE);
			UserDao userDao = factory.getUserDao();
			
			User user = new User(300, "update300", "pas", null, new UserStatus(1, " "), new UserRole(1, " "));
			userDao.updateUser(300, user);
			for(User i: userDao.getAllUsers()) {
				System.out.println(i.toString());
			}
			Ship ship = new Ship(11, "Ships", 300);
			userDao.createShip(4, ship);
			System.out.println(userDao.getUserShip(300).toString());
			PierDao pierDao = factory.getPierDao();
			Pier pier3 = new Pier(300, 1000);
			pierDao.createPier(pier3);
			Pier pier4 = new Pier(1, 0);
			pierDao.updatePier(1, pier4);
			for(Pier pier: pierDao.getAllPiers()) {
				System.out.println(pier.toString());
			}
			StatementDao statementDao = factory.getStatementDao();
			for(Statement statement: statementDao.getAllStatements()) {
				System.out.println(statement.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
		System.out.println("post");
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ICommand command = CommandFactory.getCommand(request);

		ICommandResult commandExecutionResult = command.execute(request);

		commandExecutionResult.toResponse(getServletContext(), request, response);
	}

	public void destroy() {
		super.destroy();
	}
}
