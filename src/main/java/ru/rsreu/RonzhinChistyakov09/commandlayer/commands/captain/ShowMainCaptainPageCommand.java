package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
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
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsStatuses"));
		StatementTypeDao statementTypeDao = (StatementTypeDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statementsTypes"));
		User user = (User) request.getSession().getAttribute(Resourcer.getString("servlet.session.attributes.user"));

		MainCaptainPageLogic logic = new MainCaptainPageLogic(statementDao, statementTypeDao, statementStatusDao);
		try {
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.enterStatements"),
					logic.getUserEnterTypeStatement(user.getId()));
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.exitStatements"),
					logic.getUserExitTypeStatement(user.getId()));
			Statement statement = logic.getCurrentStatement(user.getId());
			if (statement != null) {
				StatementStatus createdStatus = logic.getCreatedStatement();
				if (statement.getStatus().equals(createdStatus)) {
					request.setAttribute(Resourcer.getString("servlet.requests.attributes.buttonTitle"),
							Resourcer.getString("servlet.requests.attributes.buttonTitle.cancel"));
					request.setAttribute(Resourcer.getString("servlet.requests.attributes.buttonCommand"),
							Resourcer.getString("servlet.requests.attributes.buttonCommand.cancel"));
				} else {
					request.setAttribute(Resourcer.getString("servlet.requests.attributes.buttonTitle"),
							Resourcer.getString("servlet.requests.attributes.buttonTitle.finish"));
					request.setAttribute(Resourcer.getString("servlet.requests.attributes.buttonCommand"),
							Resourcer.getString("servlet.requests.attributes.buttonCommand.finish"));
				}
				page = Resourcer.getString("jsp.captain.main.process");
				request.setAttribute(Resourcer.getString("servlet.requests.attributes.statement"), statement);
				request.setAttribute("typeOfUnloadingButton", "hidden");
				request.setAttribute("typeOfLoadingButton", "hidden");
			} else {
				Statement lastStatement = logic.getLastFinishedStatement(user.getId());
				StatementType exitType = logic.getExitType();
				if (lastStatement == null || lastStatement.getType().equals(exitType)) {
					request.setAttribute("statementType", "enter");
					request.setAttribute("typeOfUnloadingButton", "hidden");
					request.setAttribute("typeOfLoadingButton", "hidden");
				} else {
					request.setAttribute("statementType", "exit");
					request.setAttribute("typeOfUnloadingButton", "submit");
					request.setAttribute("typeOfLoadingButton", "submit");
				}
			}
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		return new CommandResultResponseForward(page);
	}

}
