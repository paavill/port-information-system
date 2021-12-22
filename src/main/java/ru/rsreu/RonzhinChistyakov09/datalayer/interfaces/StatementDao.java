package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface StatementDao {
	Collection<Statement> getAllStatements() throws DataRequestException;

	void createStatement(Statement statement) throws DataRequestException;

	Statement getLastByUserId(int userId) throws DataRequestException;

	int getCount() throws DataRequestException;

	Collection<Statement> getUserStatementsByType(int userId, StatementType type) throws DataRequestException;

	Collection<Statement> getStatementsByStatus(StatementStatus status) throws DataRequestException;

	Statement getById(int statementId) throws DataRequestException;

	void updateStatus(StatementStatus status, int id) throws DataRequestException;

	void updatePier(int statementId, int pierId) throws DataRequestException;

	Statement getLastFinishedStatement(int userId) throws DataRequestException;

	Collection<Statement> getStatementsByShip(int shipId) throws DataRequestException;

	Statement getLastByPier(int id) throws DataRequestException;
}
