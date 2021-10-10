package ru.rsreu.RonzhinChistyakov09.commands;

public enum CommandEnum {
	SHOW_MAIN_NO_LOGIN_PAGE {
		{
			this.command = new ShowMainNoLoginPageCommand();
		}
	},
	SHOW_LOGIN_PAGE {
		{
			this.command = new ShowLoginPageCommand();
		}
	};

	ICommand command;

	public ICommand getCurrentCommand() {
		return command;
	}
}
