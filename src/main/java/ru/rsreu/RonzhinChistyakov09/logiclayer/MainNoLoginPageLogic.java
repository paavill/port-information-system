package ru.rsreu.RonzhinChistyakov09.logiclayer;

import java.util.Collection;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.data.Port;
import ru.rsreu.RonzhinChistyakov09.datalayer.data.pier.Pier;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.PierDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;

public class MainNoLoginPageLogic {

	private PierDao pierDao;

	public MainNoLoginPageLogic(PierDao pierDao) {
		this.pierDao = pierDao;
	}

	public Port getPort() throws DataRequestException {
		int piersCount = getPiersCount();
		int freePiersCount = getFreePiersCount();
		String portName = Resourcer.getString("port.info.name");
		return new Port(portName, piersCount, freePiersCount);
	}

	private int getPiersCount() throws DataRequestException {
		return pierDao.getPiersCount();
	}

	private int getFreePiersCount() throws DataRequestException {
		return pierDao.getFreePiersCount();
	}

	public Collection<Pier> getPiers() throws DataRequestException {
		return pierDao.getAllPiers();
	}
}
