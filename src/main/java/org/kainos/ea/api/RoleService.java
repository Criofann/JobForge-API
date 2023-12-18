package org.kainos.ea.api;

import org.kainos.ea.cli.Band;
import org.kainos.ea.cli.Role;
import org.kainos.ea.client.BandDoesNotExistException;
import org.kainos.ea.client.FailedToGetBandsException;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.BandDao;
import org.kainos.ea.db.RoleDAO;

import java.sql.SQLException;
import java.util.List;

public class RoleService {
    RoleDAO roleDAO = new RoleDAO();
    public List<Role> getRoles() throws FailedToGetRolesException {
        List<Role> roleList;
        try {
            roleList = roleDAO.getRoles();

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return roleList;
    }
}
