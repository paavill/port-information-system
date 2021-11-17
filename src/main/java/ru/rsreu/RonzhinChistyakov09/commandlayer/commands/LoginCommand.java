package ru.rsreu.RonzhinChistyakov09.commandlayer.commands;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseForward;
import ru.rsreu.RonzhinChistyakov09.commandlayer.CommandResultResponseSendRedirect;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommand;
import ru.rsreu.RonzhinChistyakov09.commandlayer.interfaces.ICommandResult;
import ru.rsreu.RonzhinChistyakov09.datalayer.DBType;
import ru.rsreu.RonzhinChistyakov09.datalayer.DaoFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;

public class LoginCommand implements ICommand {

	@Override
	public ICommandResult execute(HttpServletRequest request) {
		boolean loginLogicResult = false;
		ICommandResult result = null;
		if (loginLogicResult) {
			// ����� SHOW_MAIN_NO_LOGIN_PAGE ���� ���, �� � ����������� �� ����, ���
			// ���������� � ������
			// ����� ������� ������ ������� (������� �������� ������ ��������), �� ����
			// ����� �������� ����� ������ �� ��������
			// ������������ � ����������� �� ��� ����
			// ����� ��� ����� ������ ��������� ������� � ��
			System.out.println("OK!");
			result = new CommandResultResponseSendRedirect("FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE");
		} else {
			String page = Resourcer.getString("jsp.login");
			request.setAttribute("errorMessage", "fail to login");
			result = new CommandResultResponseForward(page);
		}
		return result;
	}
}
