package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.captain.ShowMainCaptainPageLogic;

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
		ShowMainCaptainPageLogic logic = new ShowMainCaptainPageLogic(statementDao, statementTypeDao,
				statementStatusDao);
		try {
			request.setAttribute("enterStatements", logic.getUserEnterTypeStatement(user.getId()));
			request.setAttribute("exitStatements", logic.getUserExitTypeStatement(user.getId()));
		} catch (DataRequestException e) {
			e.printStackTrace();
		}

		request.setAttribute("typeOfCreatingStatementText", "Create statement");
		request.setAttribute("statementType", "CREATE_ENTER_STATEMENT");
		request.setAttribute("typeOfUnloadingButton", "hidden");
		request.setAttribute("typeOfLoadingButton", "hidden");
		// check other data attrubute
		// we need to check is user in port or not in:
		// show unload product page and unload product commands
		// and all this in load commands
		return new CommandResultResponseForward(page);
	}

}
