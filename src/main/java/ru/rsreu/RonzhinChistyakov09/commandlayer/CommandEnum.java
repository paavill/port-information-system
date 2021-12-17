package ru.rsreu.RonzhinChistyakov09.commandlayer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.LoginCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.LogoutCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.RoutingUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowLoginPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.ShowMainNoLoginPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.ShowMainAdminPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.CreatePierCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.CreateShipCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.CreateUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.ShowCreatePierPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.ShowCreateShipPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.create.ShowCreateUserPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete.DeletePierCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete.DeleteShipCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.delete.DeleteUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.edit.EditUserCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.admin.edit.ShowEditUserPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.CreateExitStatementCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.CreateEnterStatementCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.ShowMainCaptainPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.ShowUnloadPageCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain.UnloadProductsCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.commands.dispatcher.ShowMainDispatcherPageCommand;
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
	//admin show commands
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
	SHOW_CREATE_PIER_PAGE {
		{
			this.command = new ShowCreatePierPageCommand();
		}
	},
	SHOW_CREATE_SHIP_PAGE{
		{
			this.command = new ShowCreateShipPageCommand();
		}
	},
	//end admin show commands
	
	//admin action commands
	CREATE_USER {
		{
			this.command = new CreateUserCommand();
		}
	},
	EDIT_USER {
		{
			this.command = new EditUserCommand();
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
	CREATE_SHIP{
		{
			this.command = new CreateShipCommand();
		}
	},
	DELETE_SHIP{
		{
			this.command = new DeleteShipCommand();
		}
	},
	//end admin action commands
	
	//dispatcher show commands
	SHOW_MAIN_DISPATCHER_PAGE{
		{
			this.command = new ShowMainDispatcherPageCommand();
		}
	},
	
	//captain show commands
	SHOW_MAIN_CAPTAIN_PAGE{
		{
			this.command = new ShowMainCaptainPageCommand();
		}
	},
	SHOW_UNLOAD_PAGE{
		{
			this.command = new ShowUnloadPageCommand();
		}
	},
	//end captain show commands
	
	//captain action commands
	CREATE_EXIT_STATEMENT{
		{
			this.command = new CreateExitStatementCommand();
		}
	},
	CREATE_ENTER_STATEMENT{
		{
			this.command = new CreateEnterStatementCommand();
		}
	},
	UNLOAD_PRODUCTS{
		{
			this.command = new UnloadProductsCommand();
		}
	},
	//end captain action commands
	
	//system commands
	ROUTING_USER {
		{
			this.command = new RoutingUserCommand();
		}
	},
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
