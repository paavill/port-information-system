package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.sql.Date;
import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

/**
 * A class that provides access to model objects of the statement type
 * 
 * @author pavel
 *
 */
public interface StatementDao {
	/**
	 * The method allows you to get all orders created in the system
	 * 
	 * @return statement collection
	 * @throws DataRequestException
	 */
	Collection<Statement> getAllStatements() throws DataRequestException;

	/**
	 * Creates a request based on the request object passed to this method
	 * 
	 * @param statement - the object on the basis of which it is created in the data
	 *                  warehouse
	 * @throws DataRequestException
	 */
	void createStatement(Statement statement) throws DataRequestException;

	/**
	 * The method allows you to get the last request that was created by the user
	 * with the passed id
	 * 
	 * @param userId
	 * @return last user request with id equal userId
	 * @throws DataRequestException
	 */
	Statement getLastByUserId(int userId) throws DataRequestException;

	/**
	 * The method counts the number of all orders in the system
	 * 
	 * @return number of statements
	 * @throws DataRequestException
	 */
	int getCount() throws DataRequestException;

	/**
	 * The method allows you to get user statements with a certain type.
	 * 
	 * @param userId - id of the user of the application which you want to get
	 * @param type   - an object of the application type, on the basis of which the
	 *               selection of applications is performed
	 * @return
	 * @throws DataRequestException
	 */
	Collection<Statement> getUserStatementsByType(int userId, StatementType type) throws DataRequestException;

	/**
	 * The method allows you to get statements with a certain status.
	 * 
	 * @param status - an object of the application status, on the basis of which the
	 *               selection of applications is performed
	 * @return
	 * @throws DataRequestException
	 */
	Collection<Statement> getStatementsByStatus(StatementStatus status) throws DataRequestException;

	/**
	 * 
	 * @param statementId
	 * @return
	 * @throws DataRequestException
	 */
	Statement getById(int statementId) throws DataRequestException;

	/**
	 * 
	 * @param status
	 * @param id
	 * @throws DataRequestException
	 */
	void updateStatus(StatementStatus status, int id) throws DataRequestException;

	/**
	 * 
	 * @param statementId
	 * @param pierId
	 * @throws DataRequestException
	 */
	void updatePier(int statementId, int pierId) throws DataRequestException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws DataRequestException
	 */
	Statement getLastFinishedStatement(int userId) throws DataRequestException;

	/**
	 * 
	 * @param shipId
	 * @return
	 * @throws DataRequestException
	 */
	Collection<Statement> getStatementsByShip(int shipId) throws DataRequestException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DataRequestException
	 */
	Statement getLastByPier(int id) throws DataRequestException;

	/**
	 * 
	 * @param date
	 * @param pierId
	 * @throws DataRequestException
	 */
	void updateFinishDate(Date date, int pierId) throws DataRequestException;
}
