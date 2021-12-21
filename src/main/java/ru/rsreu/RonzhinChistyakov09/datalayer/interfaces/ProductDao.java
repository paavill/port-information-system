package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface ProductDao {
	
	abstract void unloadProductsToPier(Collection<Product> products) throws DataRequestException;
	
	abstract void loadProductsFromPier(Collection<Product> products) throws DataRequestException;
	
	abstract Collection<Product> getAllProducts() throws DataRequestException;
	
	abstract Collection<Product> getProductsInPier(int pierId) throws DataRequestException;

	abstract int getCountProduct(String title, int pierId) throws DataRequestException;

}
