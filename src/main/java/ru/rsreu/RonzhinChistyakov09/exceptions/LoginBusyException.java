package ru.rsreu.RonzhinChistyakov09.exceptions;

public class LoginBusyException extends Exception {

	private static final long serialVersionUID = 6837215397593233335L;

	public LoginBusyException(String message) {
		super(message);
	}

}
