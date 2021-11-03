package ru.rsreu.RonzhinChistyakov09.commandlayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;

public class CommandResultResponseForward implements ICommandResult {

	private final String page;
	
	public CommandResultResponseForward(String page) {
		super();
		this.page = page;
	}

	@Override
	public void toResponse(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
