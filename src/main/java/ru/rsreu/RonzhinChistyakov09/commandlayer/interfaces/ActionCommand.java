package ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface ActionCommand {
	ActionCommandResult execute(HttpServletRequest request) throws DataRequestException;
}
