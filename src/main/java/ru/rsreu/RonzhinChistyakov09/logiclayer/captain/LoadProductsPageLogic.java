package ru.rsreu.RonzhinChistyakov09.logiclayer.captain;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ProductDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class LoadProductsPageLogic {

	private final StatementDao statementDao;
	private final ProductDao productDao;

	public LoadProductsPageLogic(StatementDao statementDao, ProductDao productDao) {
		this.statementDao = statementDao;
		this.productDao = productDao;
	}

	public Collection<Product> getProducts(int userId) throws DataRequestException {
		Statement lastStatement = this.statementDao.getLastFinishedStatement(userId);
		return productDao.getProductsInPier(lastStatement.getPier().getId());
	}

}
