package org.kainos.ea.api;

import org.kainos.ea.cli.BandRole;
import org.kainos.ea.cli.Role;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDAO;
import java.sql.SQLException;
import java.util.List;

public class RoleService {
    private RoleDAO roleDao;
    private DatabaseConnector databaseConnector;

    public RoleService(RoleDAO roleDao, DatabaseConnector databaseConnector) {
        this.roleDao = roleDao;
        this.databaseConnector = databaseConnector;
    }

    public List<Role> getRoles() throws FailedToGetRolesException {
        List<Role> roleList;
        try {
            roleList = roleDao.getRoles();

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return roleList;
    }

    public List<BandRole> getBandRole() throws FailedToGetRolesException {
        List<BandRole> roleList;
        try {
            roleList = roleDao.getBandRole();

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return roleList;
    }
}
