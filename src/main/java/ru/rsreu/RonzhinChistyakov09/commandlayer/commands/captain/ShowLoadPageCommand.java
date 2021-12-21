package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ProductDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class ShowLoadPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		ProductDao productDao = (ProductDao) request.getServletContext()
				.getAttribute(Resourcer.getString("serlvet.context.dao.products"));
		Collection<Product> products = new ArrayList<Product>();
		try {
			int pierId = 1;//get from dao for current captain
			products = productDao.getProductsInPier(pierId);
		} catch (DataRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute(Resourcer.getString("servlet.requests.attributes.productsData"), products);
		return new CommandResultResponseForward(Resourcer.getString("jsp.captain.load"));
	}

}
