package org.kainos.ea.api;

import org.kainos.ea.cli.Band;
import org.kainos.ea.client.FailedToGetBandsException;
import org.kainos.ea.db.BandDao;
import java.sql.SQLException;
import java.util.List;

public class BandService {
    BandDao bandDao = new BandDao();
    public List<Band> getBands() throws FailedToGetBandsException {
        List<Band> bandList;
        try {
            bandList = bandDao.getBands();

        } catch (SQLException e) {
            throw new FailedToGetBandsException();
        }

        return bandList;
    }
}
