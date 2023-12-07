package org.kainos.ea.api;

import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.cli.Role;
import org.kainos.ea.client.*;
import org.kainos.ea.core.JobFamilyValidator;
import org.kainos.ea.core.JobValidator;
import org.kainos.ea.db.RoleDao;

import java.sql.SQLException;
import java.util.List;

public class RoleService {
    RoleDao roleDao = new RoleDao();
    private JobValidator jobValidator = new JobValidator();
    private JobFamilyValidator jobFamilyValidator = new JobFamilyValidator();
    public List<Role> getRoles() throws FailedToGetRolesException {
        List<Role> roleList;
        try {
            roleList = roleDao.getRoles();

        } catch (SQLException e) {
            throw new FailedToGetRolesException();
        }

        return roleList;
    }
    public int createJob(JobRequest jobRequest) throws FailedToCreateJobException, InvalidJobException {
        try {
            String validation = jobValidator.isValidJob(jobRequest);

            if (validation != null) {
                throw new InvalidJobException(validation);
            }
            int id = roleDao.createJob(jobRequest);
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateJobException();
        }

    }

    public int createJobFamily(JobFamilyRequest jobFamilyRequest)
            throws FailedToCreateJobFamilyException, InvalidJobFamilyException {

    try {
        String validation = jobFamilyValidator.isValidJobFamily(jobFamilyRequest);

        if (validation != null) {
            throw new InvalidJobFamilyException(validation);
        }
        int id = roleDao.createJobFamiliy(jobFamilyRequest);
        return id;
    } catch (SQLException e) {
        System.err.println(e.getMessage());
        throw new FailedToCreateJobFamilyException();
    }

}
}
