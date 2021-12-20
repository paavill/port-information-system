package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface ProductDao {
	
	void unloadProductsToPier(Collection<Product> goods) throws DataRequestException;
	
	Collection<Product> getAllProducts() throws DataRequestException;

}
