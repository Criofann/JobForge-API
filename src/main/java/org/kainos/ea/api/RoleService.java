package org.kainos.ea.api;

import org.kainos.ea.cli.Role;
import org.kainos.ea.client.FailedToDeleteRoleException;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.client.RoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class RoleService {
    private final RoleDao roleDao;
    private final DatabaseConnector databaseConnector;

    public RoleService(RoleDao roleDao, DatabaseConnector databaseConnector) {
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

    public Role getRoleByID(String roleName) throws FailedToGetRolesException, RoleDoesNotExistException {
        try {
            Role role = roleDao.getRoleByID(roleName, databaseConnector.getConnection());
            if (role == null) {
                throw new RoleDoesNotExistException();
            }
            return role;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetRolesException();
        }
    }

    public void deleteRole(String roleName )  throws RoleDoesNotExistException, FailedToDeleteRoleException {
        try {
            Role roleToDelete = roleDao.getRoleByID(roleName, databaseConnector.getConnection());

            if (roleToDelete == null) {
                throw new RoleDoesNotExistException();
            }

            roleDao.deleteRole(roleName, databaseConnector.getConnection());
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteRoleException();
        }
    }
}
