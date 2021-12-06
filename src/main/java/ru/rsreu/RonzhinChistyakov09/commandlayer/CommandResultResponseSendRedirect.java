package ru.rsreu.RonzhinChistyakov09.commandlayer;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;

public class CommandResultResponseSendRedirect implements ActionCommandResult {

	private final String pathToRedirect;
	
	public CommandResultResponseSendRedirect(String pathToRedirect) {
		super();
		this.pathToRedirect = pathToRedirect;
	}

	@Override
	public void toResponse(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(pathToRedirect);
	}

}
