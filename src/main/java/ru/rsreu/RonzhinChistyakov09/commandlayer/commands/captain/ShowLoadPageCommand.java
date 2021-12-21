package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ProductDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.logiclayer.captain.LoadProductsPageLogic;

public class ShowLoadPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		ProductDao productDao = (ProductDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.products"));
		StatementDao statementDao = (StatementDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.statements"));
		User user = (User) request.getSession().getAttribute(Resourcer.getString("servlet.session.attributes.user"));

		LoadProductsPageLogic logic = new LoadProductsPageLogic(statementDao, productDao);
		try {
			request.setAttribute(Resourcer.getString("servlet.requests.attributes.productsData"),
					logic.getProducts(user.getId()));
		} catch (DataRequestException e) {
			e.printStackTrace();
		}
		return new CommandResultResponseForward(Resourcer.getString("jsp.captain.load"));
	}

}
