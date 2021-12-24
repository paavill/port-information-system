package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * A class that provides access to model objects of the product type
 * 
 * @author pavel
 *
 */
public interface ProductDao {
	/**
	 * A method that allows you to unload products from the ship to the pier, which
	 * is indicated in the product.
	 * 
	 * @param products - The list of products that will be unloaded each in the case
	 *                 that is specified in the product object.
	 * @throws DataRequestException
	 */
	void unloadProductsToPier(Collection<Product> products) throws DataRequestException;

	/**
	 * The method allows you to load products from the pier that is specified in the
	 * product objects.
	 * 
	 * @param products - The list of products that will be loaded each in the case
	 *                 that is specified in the product object.
	 * @throws DataRequestException
	 */
	void loadProductsFromPier(Collection<Product> products) throws DataRequestException;

	/**
	 * The method allows you to get a list of all products.
	 * 
	 * @return collection of products
	 * @throws DataRequestException
	 */
	Collection<Product> getAllProducts() throws DataRequestException;

	/**
	 * Allows you to get food objects located in a specific pier
	 * 
	 * @param pierId - id of the pier whose products you want to get
	 * @return collection of products
	 * @throws DataRequestException
	 */
	Collection<Product> getProductsInPier(int pierId) throws DataRequestException;

	/**
	 * The method allows you to get the number of products that have a specific name
	 * in the pier
	 * 
	 * @param title  - The name of the products we want to receive
	 * @param pierId - id of the pier in which the products are counted
	 * @return Number of products in the pier
	 * @throws DataRequestException
	 */
	int getCountProduct(String title, int pierId) throws DataRequestException;

}
