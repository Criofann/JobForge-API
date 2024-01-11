package org.kainos.ea.api;

import org.kainos.ea.cli.BandRole;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.BandRoleDao;

import java.sql.SQLException;
import java.util.List;

public class BandRoleService {
    private final BandRoleDao bandRoleDao = new BandRoleDao();
    public List<BandRole> getBandRole() throws FailedToGetRolesException {
        List<BandRole> bandRoleList;
        try {
            bandRoleList = bandRoleDao.getBandRole();

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return bandRoleList;
    }
}
