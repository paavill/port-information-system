package ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
	ICommandResult execute(HttpServletRequest request);
}
