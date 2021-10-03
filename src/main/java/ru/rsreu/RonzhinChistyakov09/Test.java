package ru.rsreu.RonzhinChistyakov09;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.DAOFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.DBType;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	public Test() {
		super();
	}

	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Locale.setDefault(Locale.US);
		try {
			DAOFactory dao = DAOFactory.getInstance(DBType.ORACLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print("This is " + this.getClass().getName() + ", using the GET method");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().print("This is " + this.getClass().getName() + ", using the POST method");
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
}
