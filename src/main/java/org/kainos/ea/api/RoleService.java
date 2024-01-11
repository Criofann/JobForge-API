package org.kainos.ea.api;

<<<<<<< HEAD
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
=======
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
>>>>>>> origin/staging-branch

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

<<<<<<< HEAD
        return roleList;
    }

    public List<BandRole> getBandRole() throws FailedToGetRolesException {
        List<BandRole> roleList;
        try {
            System.out.println(" Role Service Test");
            roleList = roleDao.getBandRole();

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return roleList;
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

