package ru.rsreu.RonzhinChistyakov09;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandFactory;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;

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
