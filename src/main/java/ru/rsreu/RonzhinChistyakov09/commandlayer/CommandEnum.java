package ru.rsreu.RonzhinChistyakov09.commandlayer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.LoginCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowLoginPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowMainNoLoginPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;

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
	},
	LOGIN{
		{
			this.command = new LoginCommand();
		}
	};

	ICommand command;

	public ICommand getCurrentCommand() {
		return command;
	}
}
