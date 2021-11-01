package ru.rsreu.RonzhinChistyakov09.commands;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.CollectionToTableFormatter;
import ru.rsreu.RonzhinChistyakov09.Port;
import ru.rsreu.RonzhinChistyakov09.Tab;
import ru.rsreu.RonzhinChistyakov09.datalayer.DaoFactory;
import ru.rsreu.RonzhinChistyakov09.datalayer.UserDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.DBType;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.UserData;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.UserRole;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.UserStatus;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class ShowMainNoLoginPageCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		//тут будет использоваться dao
		Collection<Port> test = new ArrayList<Port>();
		test.add(new Port("PortName", 1, 1, 1, 1));

		Collection<Tab> testTabData = new ArrayList<Tab>();
		testTabData.add(new Tab("TestNameFromFC1", test));
		testTabData.add(new Tab("TestNameFromFC2", test));
		testTabData.add(new Tab("TestNameFromFC3", test));

		page = Resourcer.getString("jsp.main.noLogin");
		request.setAttribute("tabs", testTabData);
		
		DaoFactory factory = null;
		try {
			factory = DaoFactory.getInstance(DBType.ORACLE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDao userDao = factory.getUserDao();
		String result = "";
		try {
			userDao.createUser(new User(5, new UserData(5, UserRole.ADMINISTRATOR, "a2", "b2", 12), "test", "test2", UserStatus.AUTHORIZED));
			Collection<User> users = userDao.getAllUsers();
			for(User user: users) {
				System.out.println(user.getData().getRole());
				System.out.println(user.getStatus());
			}
			result += CollectionToTableFormatter.format(users);
		} catch (DataRequestException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return page;
	}

}
