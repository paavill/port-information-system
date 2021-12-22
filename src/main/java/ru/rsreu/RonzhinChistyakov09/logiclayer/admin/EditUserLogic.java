package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.user.User;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.UserDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.LoginBusyException;

public class EditUserLogic {

	UserDao userDao;

	public EditUserLogic(UserDao userDao) {
		this.userDao = userDao;
	}

	public void editUser(User user) throws DataRequestException, LoginBusyException {
		String oldLogin = userDao.getUserById(user.getId()).getLogin();
		String newLogin = user.getLogin();
		if (checkLogin(oldLogin, newLogin)) {
			throw new LoginBusyException(
					String.format(Resourcer.getString("exceptions.captain.create.user"), user.getLogin()));
		}
		this.userDao.updateUser(user);
	}

	private boolean checkLogin(String oldLogin, String newLogin) throws DataRequestException {
		return !(oldLogin.equals(newLogin) || userDao.getUserByLogin(newLogin) == null);
	}
}
