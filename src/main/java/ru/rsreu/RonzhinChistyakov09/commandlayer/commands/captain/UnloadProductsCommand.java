package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ProductDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class UnloadProductsCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		ProductDao productDao = (ProductDao) request.getServletContext().getAttribute(Resourcer.getString("serlvet.context.dao.products"));
		String productFormsAsJson = request.getParameter("jsonProducts");
		System.out.println("json:" + productFormsAsJson);
		List<ProductForm> productForms = deserializeJsonToProductForms(productFormsAsJson);
		productForms.forEach(e -> {
			System.out.println("Title:" + e.getTitle());
			System.out.println("Number:" + e.getNumber());
		});
		
		int pierId = 1;//need get from dao
		//and add login, sorry that without it
		final Collection<Product> products = new ArrayList<Product>();
		productForms.forEach(e -> {
			products.add(new Product(e.getTitle(), pierId, e.getNumber()));
		});
		
		try {
			productDao.unloadProductsToPier(products);
		} catch (DataRequestException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Collection<Product> products1 = new ArrayList<Product>();
		try {
			products1 = productDao.getAllProducts();
		} catch (DataRequestException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		products1.forEach(e -> {
			System.out.println(e.toString());
		});
		
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
	}
	
	private List<ProductForm> deserializeJsonToProductForms(String json) {
        Type token = new TypeToken<Collection<ProductForm>>() {
        }.getType();
        return new Gson().fromJson(json, token);
    }

}
