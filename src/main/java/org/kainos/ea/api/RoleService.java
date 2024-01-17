package org.kainos.ea.api;

import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.cli.Role;

import org.kainos.ea.client.FailedToDeleteRoleException;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.client.RoleDoesNotExistException;

import org.kainos.ea.client.FailedToCreateJobException;
import org.kainos.ea.client.InvalidJobException;
import org.kainos.ea.client.ValidationException;
import org.kainos.ea.core.JobValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;

import java.sql.SQLException;
import java.util.List;


public class RoleService {
    private RoleDao roleDao;
    private DatabaseConnector databaseConnector;
    private JobValidator jobValidator;

    public RoleService(RoleDao roleDao, DatabaseConnector databaseConnector,
                       JobValidator jobValidator) {
        this.roleDao = roleDao;
        this.databaseConnector = databaseConnector;
        this.jobValidator = jobValidator;
    }

    public List<Role> getRoles()
            throws FailedToGetRolesException {
        try {
            return roleDao.getRoles(databaseConnector.getConnection());

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

    }

    public void createJob(RoleRequest roleRequest)
            throws FailedToCreateJobException,
            SQLException, InvalidJobException,
            ValidationException {
          jobValidator.isValidJob(roleRequest);

          roleDao.createJob(roleRequest,
                  databaseConnector.getConnection());

    }

    public Role getRoleByID(String roleName)
            throws FailedToGetRolesException, RoleDoesNotExistException {
        try {
            Role role = roleDao.getRoleByID(
                    roleName, databaseConnector.getConnection());
            if (role == null) {
                throw new RoleDoesNotExistException();
            }
            return role;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetRolesException();
        }
    }

    public void deleteRole(String roleName)
            throws RoleDoesNotExistException,
            FailedToDeleteRoleException {
        try {
            Role roleToDelete = roleDao.getRoleByID(
                    roleName, databaseConnector.getConnection());

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

