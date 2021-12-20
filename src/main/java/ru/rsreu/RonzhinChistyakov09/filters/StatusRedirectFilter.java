package ru.rsreu.RonzhinChistyakov09.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandEnum;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.UserStatus;

public class StatusRedirectFilter implements Filter {

	private List<CommandEnum> availableCommands = new ArrayList<>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		Locale.setDefault(Locale.US);
		availableCommands.add(CommandEnum.LOGIN);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isErrorCommand = false;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		User user = (User) httpRequest.getSession()
				.getAttribute(Resourcer.getString("servlet.session.attributes.user"));
		if (user == null) {
			chain.doFilter(request, response);
		} else {
			UserStatus status = user.getStatus();

			String action = httpRequest.getParameter("command");
			CommandEnum commandEnum = CommandEnum.LOGIN;// block_page_show
			if (!(action == null || action.isEmpty())) {
				try {
					commandEnum = CommandEnum.valueOf(action.toUpperCase());
				} catch (IllegalArgumentException exception) {
					System.err.println(exception.getMessage());
					isErrorCommand = true;
				}
			}

			if (!status.getTitle().equals(Resourcer.getString("database.users.statuses.blocked")) || isErrorCommand) {
				chain.doFilter(request, response);
			} else if (!availableCommands.contains(commandEnum)) {
				this.sessionInvalidate(request);
				((HttpServletResponse) response).sendRedirect("FrontController?command=SHOW_BLOCKED_PAGE");
			} else {
				this.sessionInvalidate(request);
				chain.doFilter(request, response);
			}

		}
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}

	private void sessionInvalidate(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}
