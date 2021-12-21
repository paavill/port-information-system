package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;

public class LoadProductsCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		String productFormsAsJson = request.getParameter("jsonProducts");
		System.out.println("json:" + productFormsAsJson);
		List<ProductForm> productForms = JsonToProductFormsDeserializator
				.deserializeJsonToProductForms(productFormsAsJson);
		productForms.forEach(e -> {
			System.out.println("Title:" + e.getTitle());
			System.out.println("Number:" + e.getNumber());
		});
		return new CommandResultResponseSendRedirect(Resourcer.getString("uri.show.mainPage.captain"));
	}

}
