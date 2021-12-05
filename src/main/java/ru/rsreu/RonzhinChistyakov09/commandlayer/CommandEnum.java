package ru.rsreu.RonzhinChistyakov09.commandlayer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.CreatePierCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.CreateUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.DeletePierCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.DeleteUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.LoginCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowCreatePierPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowCreateUserPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowLoginPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowMainAdminPageCommand;
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
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},

	SHOW_MAIN_ADMIN_PAGE {
		{
			this.command = new ShowMainAdminPageCommand();
		}
	},
	SHOW_CREATE_USER_PAGE {
		{
			this.command = new ShowCreateUserPageCommand();
		}
	},
	CREATE_USER {
		{
			this.command = new CreateUserCommand();
		}
	},
	SHOW_CREATE_PIER_PAGE {
		{
			this.command = new ShowCreatePierPageCommand();
		}
	},
	CREATE_PIER {
		{
			this.command = new CreatePierCommand();
		}
	},
	DELETE_USER {
		{
			this.command = new DeleteUserCommand();
		}
	},
	DELETE_PIER {
		{
			this.command = new DeletePierCommand();
		}
	};

	ICommand command;

	public ICommand getCurrentCommand() {
		return command;
	}
}
