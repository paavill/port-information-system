package ru.rsreu.RonzhinChistyakov09.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandEnum;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;

public class RoleRedirectFilter implements Filter {

	private Map<String, List<CommandEnum>> roleWithCommandMap;
	private final String guestRoleTitle = "GUEST";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		Locale.setDefault(Locale.US);

		final String adminRoleTitle = Resourcer.getString("database.users.roles.administrator");
		final String dispatcherRoleTitle = Resourcer.getString("database.users.roles.dispatcher");
		final String moderatorRoleTitle = Resourcer.getString("database.users.roles.moderator");
		final String captainRoleTitle = Resourcer.getString("database.users.roles.captain");

		roleWithCommandMap = new HashMap<String, List<CommandEnum>>();

		List<CommandEnum> guestCommands = new ArrayList<>();
		guestCommands.add(CommandEnum.LOGIN);
		guestCommands.add(CommandEnum.SHOW_LOGIN_PAGE);
		guestCommands.add(CommandEnum.SHOW_MAIN_NO_LOGIN_PAGE);
		roleWithCommandMap.put(guestRoleTitle, guestCommands);

		List<CommandEnum> administratorCommands = new ArrayList<>();
		administratorCommands.add(CommandEnum.SHOW_MAIN_ADMIN_PAGE);
		administratorCommands.add(CommandEnum.SHOW_CREATE_USER_PAGE);
		administratorCommands.add(CommandEnum.SHOW_CREATE_PIER_PAGE);
		administratorCommands.add(CommandEnum.SHOW_CREATE_SHIP_PAGE);
		administratorCommands.add(CommandEnum.SHOW_EDIT_USER_PAGE);
		administratorCommands.add(CommandEnum.CREATE_USER);
		administratorCommands.add(CommandEnum.CREATE_PIER);
		administratorCommands.add(CommandEnum.CREATE_SHIP);
		administratorCommands.add(CommandEnum.EDIT_USER);
		administratorCommands.add(CommandEnum.DELETE_PIER);
		administratorCommands.add(CommandEnum.DELETE_SHIP);
		administratorCommands.add(CommandEnum.DELETE_USER);
		administratorCommands.add(CommandEnum.LOGOUT);
		administratorCommands.add(CommandEnum.ROUTING_USER);
		roleWithCommandMap.put(adminRoleTitle, administratorCommands);

		List<CommandEnum> dispatcherCommands = new ArrayList<>();
		dispatcherCommands.add(CommandEnum.SHOW_MAIN_DISPATCHER_PAGE);
		dispatcherCommands.add(CommandEnum.SHOW_PROCESS_STATEMENT_PAGE);
		dispatcherCommands.add(CommandEnum.REJECT_STATEMENT);
		dispatcherCommands.add(CommandEnum.PROCESS_STATEMENT);
		dispatcherCommands.add(CommandEnum.APPLY_STATEMENT);
		dispatcherCommands.add(CommandEnum.LOGOUT);
		dispatcherCommands.add(CommandEnum.ROUTING_USER);
		roleWithCommandMap.put(dispatcherRoleTitle, dispatcherCommands);

		List<CommandEnum> moderatorCommands = new ArrayList<>();
		moderatorCommands.add(CommandEnum.SHOW_MAIN_MODERATOR_PAGE);
		moderatorCommands.add(CommandEnum.BLOCK_USER);
		moderatorCommands.add(CommandEnum.UNBLOCK_USER);
		moderatorCommands.add(CommandEnum.LOGOUT);
		moderatorCommands.add(CommandEnum.ROUTING_USER);
		roleWithCommandMap.put(moderatorRoleTitle, moderatorCommands);

		List<CommandEnum> captainCommands = new ArrayList<>();
		captainCommands.add(CommandEnum.SHOW_MAIN_CAPTAIN_PAGE);
		captainCommands.add(CommandEnum.SHOW_PROCESS_STATEMENT_PAGE);
		captainCommands.add(CommandEnum.SHOW_UNLOAD_PAGE);
		captainCommands.add(CommandEnum.SHOW_LOAD_PAGE);
		captainCommands.add(CommandEnum.CREATE_STATEMENT);
		captainCommands.add(CommandEnum.CANCEL_STATEMENT);
		captainCommands.add(CommandEnum.FINISH_STATEMENT);
		captainCommands.add(CommandEnum.UNLOAD_PRODUCTS);
		captainCommands.add(CommandEnum.LOAD_PRODUCTS);
		captainCommands.add(CommandEnum.LOGOUT);
		captainCommands.add(CommandEnum.ROUTING_USER);
		roleWithCommandMap.put(captainRoleTitle, captainCommands);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		boolean isErrorCommand = false;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		User user = (User) httpRequest.getSession()
				.getAttribute(Resourcer.getString("servlet.session.attributes.user"));
		String role = guestRoleTitle;
		if (user != null) {
			role = user.getRole().getTitle().toUpperCase();
		}

		String action = httpRequest.getParameter("command");
		CommandEnum commandEnum = CommandEnum.SHOW_MAIN_NO_LOGIN_PAGE;
		if (!(action == null || action.isEmpty())) {
			try {
				commandEnum = CommandEnum.valueOf(action.toUpperCase());
			} catch (IllegalArgumentException exception) {
				System.err.println(exception.getMessage());
				isErrorCommand = true;
			}
		}

		List<CommandEnum> commands = roleWithCommandMap.get(role);

		if (commands.contains(commandEnum) || isErrorCommand) {
			filterChain.doFilter(request, response);
		} else if (user == null) {
			((HttpServletResponse) response).sendRedirect(Resourcer.getString("uri.show.mainPage.noLogin"));
		} else {
			((HttpServletResponse) response).sendRedirect(Resourcer.getString("uri.routing"));
			System.err.println("Command not avalible for user!");
		}
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
