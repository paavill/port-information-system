package ru.rsreu.RonzhinChistyakov09.commandlayer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.LoginCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowLoginPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowMainNoLoginPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.ShowMainAdminPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.CreatePierCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.CreateUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.ShowCreatePierPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.ShowCreateUserPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete.DeletePierCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete.DeleteUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.edit.EditUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.edit.ShowEditUserPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;

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
	SHOW_EDIT_USER_PAGE {
		{
			this.command = new ShowEditUserPageCommand();
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
	},
	EDIT_USER {
		{
			this.command = new EditUserCommand();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
