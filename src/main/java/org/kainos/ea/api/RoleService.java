package org.kainos.ea.api;

import org.kainos.ea.cli.JobRequest;
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

    public RoleService(RoleDao roleDao, DatabaseConnector databaseConnector) {
        this.roleDao = roleDao;
        this.databaseConnector = databaseConnector;
    }


    private JobValidator jobValidator = new JobValidator();





    public List<Role> getRoles()
            throws FailedToGetRolesException {
        List<Role> roleList;
        try {
            roleList = roleDao.getRoles(databaseConnector.getConnection());
            return roleList;
        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

    }

    public void createJob(JobRequest jobRequest)
            throws FailedToCreateJobException,
            SQLException, InvalidJobException,
            ValidationException {
          jobValidator.isValidJob(jobRequest);

          roleDao.createJob(jobRequest,
                  databaseConnector.getConnection());

    }
}

