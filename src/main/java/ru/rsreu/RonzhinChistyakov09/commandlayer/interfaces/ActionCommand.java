package ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
	ActionCommandResult execute(HttpServletRequest request);
}
