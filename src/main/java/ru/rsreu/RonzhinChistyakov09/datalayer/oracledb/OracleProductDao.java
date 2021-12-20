package ru.rsreu.RonzhinChistyakov09.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.product.Product;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ProductDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class OracleProductDao implements ProductDao{

	private Connection connection;

	public OracleProductDao(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void unloadProductsToPier(Collection<Product> products) throws DataRequestException {
		String query = Resourcer.getString("requests.sql.create.product");
		try{
			for(Product product:products)
			{
				for(int i = 0; i < product.getCount(); i++) {
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					PreparedStatementParametresSetter.set(preparedStatement, product.getTitle(), product.getPierId());
					preparedStatement.executeUpdate();
				}
			};
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
	}

	@Override
	public Collection<Product> getAllProducts() throws DataRequestException {
		Collection<Product> result = new ArrayList<Product>();
		String query = Resourcer.getString("requests.sql.get.products.allProducts");
		try (Statement statement = this.connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					Product product = ResultSetConverter.getProduct(resultSet);
					result.add(product);
				}
			}
		} catch (SQLException e) {
			throw new DataRequestException(
					String.format(Resourcer.getString("exceptions.sql.request"), e.getMessage()));
		}
		return result;
	}

}
