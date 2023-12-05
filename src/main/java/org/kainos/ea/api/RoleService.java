package org.kainos.ea.api;

import org.kainos.ea.cli.Role;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.RoleDao;

import java.sql.SQLException;
import java.util.List;

public class RoleService {
    RoleDao roleDao = new RoleDao();
    public List<Role> getRoles() throws FailedToGetRolesException {
        List<Role> roleList;
        try {
            roleList = roleDao.getRoles();

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return roleList;
    }
}
