package ru.rsreu.RonzhinChistyakov09.commands;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
	String execute(HttpServletRequest request);
}
