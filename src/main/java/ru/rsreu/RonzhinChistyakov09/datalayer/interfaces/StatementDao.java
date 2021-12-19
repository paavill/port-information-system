package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementStatus;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.StatementType;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface StatementDao {
	abstract Collection<Statement> getAllStatements() throws DataRequestException;	
	
	abstract void createStatement(Statement statement) throws DataRequestException;
	
	abstract Statement getLastByUserId(int userId) throws DataRequestException;
	
	abstract int getCount() throws DataRequestException;

	abstract Collection<Statement> getUserStatementsByType(int userId, StatementType type, StatementStatus status) throws DataRequestException;

	abstract Collection<Statement> getStatementsByStatus(StatementStatus status) throws DataRequestException;

	abstract Statement getById(int statementId) throws DataRequestException;

	abstract void updateStatus(StatementStatus status, int id) throws DataRequestException;
}
