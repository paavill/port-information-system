package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface ProductDao {
	
	void unloadProductsToPier(Collection<Product> products) throws DataRequestException;
	
	void loadProductsFromPier(Collection<Product> products) throws DataRequestException;
	
	Collection<Product> getAllProducts() throws DataRequestException;
	
	Collection<Product> getProductsInPier(int pierId) throws DataRequestException;

}
