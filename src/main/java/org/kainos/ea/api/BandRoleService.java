package org.kainos.ea.api;

import org.kainos.ea.cli.BandRole;
import org.kainos.ea.cli.Role;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.BandRoleDAO;
import org.kainos.ea.db.RoleDao;

import java.sql.SQLException;
import java.util.List;

public class BandRoleService {
    BandRoleDAO bandRoleDAO = new BandRoleDAO();
    public List<BandRole> getBandRole() throws FailedToGetRolesException {
        List<BandRole> bandRoleList;
        try {
            bandRoleList = bandRoleDAO.getBandRole();

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return bandRoleList;
    }
}
