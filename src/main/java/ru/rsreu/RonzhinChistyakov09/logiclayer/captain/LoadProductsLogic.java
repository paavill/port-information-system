package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.ProductForm;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ProductDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class LoadProductsLogic {

	private final ProductDao productDao;
	private final StatementDao statementDao;
	
	public LoadProductsLogic(ProductDao productDao, StatementDao statementDao) {
		this.productDao = productDao;
		this.statementDao = statementDao;
	}

	public void loadProducts(List<ProductForm> productForms, int userId) throws DataRequestException {
		Statement lastStatement = this.statementDao.getLastFinishedStatement(userId);
		int pierId = lastStatement.getPier().getId();
		
		Collection<Product> products = new ArrayList<Product>();
		productForms.forEach(it -> {
			products.add(new Product(it.getTitle(), pierId, it.getNumber()));
		});
		
		this.productDao.loadProductsFromPier(products);
	}

}
