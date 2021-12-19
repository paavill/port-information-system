package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.captain.MainCaptainPageLogic;

public class ShowMainCaptainPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		String page = Resourcer.getString("jsp.captain.main");
		StatementDao statementDao = (StatementDao) request.getServletContext().getAttribute("statementDao");
		StatementTypeDao statementTypeDao = (StatementTypeDao) request.getServletContext()
				.getAttribute("statementTypeDao");
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute("statementStatusDao");
		User user = (User) request.getSession().getAttribute("user");
		MainCaptainPageLogic logic = new MainCaptainPageLogic(statementDao, statementTypeDao,
				statementStatusDao);
		try {
			for(Statement st: logic.getUserEnterTypeStatement(user.getId())){
				System.out.println(st);
			}
			request.setAttribute("enterStatements", logic.getUserEnterTypeStatement(user.getId()));
			request.setAttribute("exitStatements", logic.getUserExitTypeStatement(user.getId()));
			Statement statement = logic.getCurrentStatement(user.getId());
			if( statement != null) {
				page = Resourcer.getString("jsp.captain.main.process");
				request.setAttribute("statement", statement);
			} else {
			}
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		request.setAttribute("typeOfUnloadingButton", "hidden");
		request.setAttribute("typeOfLoadingButton", "hidden");
		return new CommandResultResponseForward(page);
	}

}
