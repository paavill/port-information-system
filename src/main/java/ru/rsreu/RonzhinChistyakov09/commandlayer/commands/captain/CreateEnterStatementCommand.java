package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementStatusDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementTypeDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.captain.CreateStatementLogic;

public class CreateEnterStatementCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		ShipDao shipDao = (ShipDao) request.getServletContext().getAttribute("shipDao");
		StatementDao statementDao = (StatementDao) request.getServletContext().getAttribute("statementDao");
		StatementTypeDao statementTypeDao = (StatementTypeDao) request.getServletContext()
				.getAttribute("statementTypeDao");
		StatementStatusDao statementStatusDao = (StatementStatusDao) request.getServletContext()
				.getAttribute("statementStatusDao");

		CreateStatementTransferObject csto = new CreateStatementTransferObject(shipDao, statementDao,
				statementStatusDao, statementTypeDao);
		try {
			Statement statement = csto.getModel(request);
			CreateStatementLogic logic = new CreateStatementLogic(statementDao);
			logic.createStatement(statement);
			System.out.println(statement);
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
	}

}
