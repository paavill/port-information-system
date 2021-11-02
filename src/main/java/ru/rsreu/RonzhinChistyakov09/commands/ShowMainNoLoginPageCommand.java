package ru.rsreu.RonzhinChistyakov09.commands;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

		String result = "";
		try {
			DaoFactory factory = DaoFactory.getInstance(DBType.ORACLE);
			UserDao userDao = factory.getUserDao();
			
//			int usersCount = userDao.getUsersCount();
//			System.out.println(usersCount);
//			int newUserId = usersCount;
//			userDao.createUser(new User(newUserId, new UserData(newUserId, UserRole.CAPTAIN, "test", "test", 12), "test", "test", UserStatus.AUTHORIZED));
			Collection<User> users = userDao.getAllUsers();
			result += CollectionToTableFormatter.format(users);
//			List<User> usersList = new ArrayList<User>(users);
			User searchUser = null;
			int searchUserId = 1;
			for(User user: users) {
				if(user.getId() == searchUserId) {
					searchUser = user;
				}
			}
			if (searchUser != null) {

				searchUser.setStatus(UserStatus.UNAUTHORIZ);
				searchUser.setLogin("New login");
				searchUser.setPassword("New login");
				userDao.updateUser(searchUser);
			}
			Collection<User> users2 = userDao.getAllUsers();
			result += CollectionToTableFormatter.format(users2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return page;
	}

}
