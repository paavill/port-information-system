package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ActionCommandResult;

public class ShowMainCaptainPageCommand implements ActionCommand {

	@Override
	public ActionCommandResult execute(HttpServletRequest request) {
		String page = Resourcer.getString("jsp.captain.main");
		boolean isInPort = true;
		if(isInPort) {
			request.setAttribute("typeOfCreatingStatementText", "Create exit statement");
			request.setAttribute("statementType", "CREATE_EXIT_STATEMENT");
			request.setAttribute("typeOfUnloadingButton", "submit");
			request.setAttribute("typeOfLoadingButton", "submit");
		} else {
			request.setAttribute("typeOfCreatingStatementText", "Create enter statement");
			request.setAttribute("statementType", "CREATE_ENTER_STATEMENT");
			request.setAttribute("typeOfUnloadingButton", "hidden");
			request.setAttribute("typeOfLoadingButton", "hidden");
		}
		//check other data attrubute
		//we need to check is user in port or not in:
		// show unload product page and unload product commands 
		// and all this in load commands
		return new CommandResultResponseForward(page);
	}

}
