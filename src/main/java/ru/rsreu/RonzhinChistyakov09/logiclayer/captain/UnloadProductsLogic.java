package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.ProductForm;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ProductDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.captain.NotEnoughPierCapacityException;

public class UnloadProductsLogic {

	private final ProductDao productDao;
	private final StatementDao statementDao;
	private final PierDao pierDao;

	public UnloadProductsLogic(ProductDao productDao, StatementDao statementDao, PierDao pierDao) {
		this.productDao = productDao;
		this.statementDao = statementDao;
		this.pierDao = pierDao;
	}

	public void unloadProducts(List<ProductForm> productForms, int userId)
			throws DataRequestException, NotEnoughPierCapacityException {
		Statement lastStatement = this.statementDao.getLastFinishedStatement(userId);
		int pierId = lastStatement.getPier().getId();

		Collection<Product> products = new ArrayList<Product>();
		productForms.forEach(it -> {
			products.add(new Product(it.getTitle(), pierId, it.getNumber()));
		});

		if (getProductsNumberSum(products) > this.pierDao.getResidualCapacity(pierId)) {
			throw new NotEnoughPierCapacityException();
		}
		this.productDao.unloadProductsToPier(products);
	}

	private int getProductsNumberSum(Collection<Product> products) {
		int numberSum = 0;
		for (Product product : products) {
			numberSum += product.getCount();
		}
		return numberSum;
	}
}
