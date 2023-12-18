package org.kainos.ea.api;

import org.kainos.ea.cli.Role;
import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.client.FailedToUpdateRoleException;
import org.kainos.ea.client.InvalidRoleException;
import org.kainos.ea.client.RoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.kainos.ea.core.RoleValidator;

import java.sql.SQLException;
import java.util.List;

public class RoleService {
    private final RoleDao roleDao;
    private final DatabaseConnector databaseConnector;

    public RoleService(RoleDao roleDao, DatabaseConnector databaseConnector) {
        this.roleDao = roleDao;
        this.databaseConnector = databaseConnector;
    }

    public List<Role> getRoles()
            throws FailedToGetRolesException {
        List<Role> roleList;
        try {
            roleList = roleDao.getRoles(databaseConnector.getConnection());

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return roleList;
    }

    public Role getRoleByID(String roleName)
            throws FailedToGetRolesException, RoleDoesNotExistException {
        try {
            Role role = roleDao.getRoleByID(roleName);
            if (role == null) {
                throw new RoleDoesNotExistException();
            }
            return role;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetRolesException();
        }
    }

    public void updateRole(String roleName, RoleRequest role)
            throws InvalidRoleException, RoleDoesNotExistException,
            FailedToUpdateRoleException {
        try {
            String validation = RoleValidator.isValidRole(role);

            if (validation != null) {
                throw new InvalidRoleException();
            }
            Role roleToUpdate = roleDao.getRoleByID(roleName);

            if (roleToUpdate == null) {
                throw new RoleDoesNotExistException();
            }
            roleDao.updateRole(roleName, role);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateRoleException();
        }
    }
}
