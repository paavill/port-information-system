package ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces;

import javax.servlet.ServletRequest;

import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public interface DataTransferObject<T> {
	T getModel(ServletRequest request) throws DataRequestException;
}
