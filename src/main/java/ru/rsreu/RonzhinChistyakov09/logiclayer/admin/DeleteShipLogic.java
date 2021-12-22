package ru.rsreu.RonzhinChistyakov09.logiclayer.admin;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.ShipDao;
import ru.rsreu.RonzhinChistyakov09.datalayer.interfaces.StatementDao;
import ru.rsreu.RonzhinChistyakov09.exceptions.DataRequestException;
import ru.rsreu.RonzhinChistyakov09.exceptions.administrator.TryDeleteUseShipException;

public class DeleteShipLogic {

	private final ShipDao shipDao;
	private final StatementDao statementDao;

	public DeleteShipLogic(StatementDao statementDao, ShipDao shipDao) {
		this.shipDao = shipDao;
		this.statementDao = statementDao;
	}

	public void deleteShip(int shipId) throws DataRequestException, TryDeleteUseShipException {
		if (!this.statementDao.getStatementsByShip(shipId).isEmpty()) {
			throw new TryDeleteUseShipException(Resourcer.getString("exceptions.captain.delete.busyShip"));
		}
		this.shipDao.deleteShip(shipId);
	}

}
