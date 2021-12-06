package ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionCommandResult {

	void toResponse(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
