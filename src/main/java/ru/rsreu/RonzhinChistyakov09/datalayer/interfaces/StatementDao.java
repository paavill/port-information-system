package ru.rsreu.RonzhinChistyakov09.datalayer.interfaces;

import java.util.Collection;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.statement.Statement;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface StatementDao {
	abstract Collection<Statement> getAllStatements() throws DataRequestException;
	
	abstract void createStatement(Statement statement) throws DataRequestException;
}
