package org.kainos.ea.api;

import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.cli.Role;

import org.kainos.ea.client.FailedToCreateJobException;
import org.kainos.ea.client.FailedToGetRolesException;
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
}

