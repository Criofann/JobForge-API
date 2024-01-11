package org.kainos.ea.api;

import org.kainos.ea.cli.Band;
import org.kainos.ea.client.BandDoesNotExistException;
import org.kainos.ea.client.FailedToGetBandsException;
import org.kainos.ea.db.BandDao;
import org.kainos.ea.db.DatabaseConnector;
import java.sql.SQLException;
import java.util.List;

public class BandService {
    private BandDao bandDao;
    private DatabaseConnector databaseConnector;

    public BandService(BandDao bandDao, DatabaseConnector databaseConnector) {
        this.bandDao = bandDao;
        this.databaseConnector = databaseConnector;
    }
    public List<Band> getBands() throws FailedToGetBandsException {
        List<Band> bandList;
        try {
            bandList = bandDao.getBands();

        } catch (SQLException e) {
            throw new FailedToGetBandsException();
        }

        return bandList;
    }
    public Band getBandByJobRole(String roleName)
            throws FailedToGetBandsException, BandDoesNotExistException {
        try {
            Band band = bandDao.getBandByJobRole(roleName);
            if (band == null) {
                throw new BandDoesNotExistException();
            }
            return band;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetBandsException();
        }
    }
}