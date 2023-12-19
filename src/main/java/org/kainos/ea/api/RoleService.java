package org.kainos.ea.api;

import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.cli.Role;
import org.kainos.ea.core.JobFamilyValidator;
import org.kainos.ea.core.JobValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.client.FailedToCreateJobException;
import org.kainos.ea.client.InvalidJobFamilyException;
import org.kainos.ea.client.NotURLException;
import org.kainos.ea.client.JobCapabilityTooLongException;
import org.kainos.ea.client.JobSpecTooLongException;
import org.kainos.ea.client.JobNameTooLongException;
import org.kainos.ea.client.JobBandTooLongException;
import org.kainos.ea.client.FailedToCreateJobFamilyException;
import org.kainos.ea.client.JobFamilyTooLongException;
import org.kainos.ea.client.InvalidJobException;
import org.kainos.ea.client.ResponsibilityTooLongException;
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
    private JobFamilyValidator jobFamilyValidator = new JobFamilyValidator();




    public List<Role> getRoles(DatabaseConnector connector)
            throws FailedToGetRolesException {
        List<Role> roleList;
        try {
            roleList = roleDao.getRoles(connector.getConnection());
        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return roleList;
    }

    public int createJob(JobRequest jobRequest)
            throws FailedToCreateJobException,
            SQLException, InvalidJobException {
       try {
           Boolean validation = jobValidator.isValidJob(jobRequest);

           int id;
           try {
               id = roleDao.createJob(jobRequest,
                       databaseConnector.getConnection());
               return id;
           } catch (SQLException e) {
               throw new SQLException();
           }

       } catch (JobNameTooLongException | JobSpecTooLongException
                | JobCapabilityTooLongException | JobBandTooLongException
                | ResponsibilityTooLongException | NotURLException e) {
            throw new RuntimeException(e);
       }
    }

    public int createJobFamily(JobFamilyRequest jobFamilyRequest)
            throws FailedToCreateJobFamilyException,
            InvalidJobFamilyException, SQLException {

    try {

        Boolean validation = jobFamilyValidator.isValidJobFamily(
                jobFamilyRequest);


        int id = roleDao.createJobFamiliy(
                jobFamilyRequest, databaseConnector.getConnection());
        return id;
    } catch (SQLException e) {
        System.err.println(e.getMessage());
        throw new SQLException();
    } catch (JobNameTooLongException | JobFamilyTooLongException e) {

        throw new RuntimeException(e);
    }

    }

}
