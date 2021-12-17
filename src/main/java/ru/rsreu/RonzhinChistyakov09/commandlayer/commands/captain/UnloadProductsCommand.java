package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

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

public class UnloadProductsCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		String productFormsAsJson = request.getParameter("jsonProducts");
		System.out.println("json:" + productFormsAsJson);
		List<ProductForm> productForms = deserializeJsonToProductForms(productFormsAsJson);
		productForms.forEach(e -> {
			System.out.println("Title:" + e.getTitle());
			System.out.println("Number:" + e.getNumber());
		});
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
	}
	
	private List<ProductForm> deserializeJsonToProductForms(String json) {
        Type token = new TypeToken<Collection<ProductForm>>() {
        }.getType();
        return new Gson().fromJson(json, token);
    }

}
