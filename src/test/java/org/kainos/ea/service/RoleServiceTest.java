package org.kainos.ea.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.JobFamilyValidator;
import org.kainos.ea.core.JobValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {
    RoleDao roleDao = Mockito.mock(RoleDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    JobValidator jobValidator = Mockito.mock(JobValidator.class);
    JobFamilyValidator jobFamilyValidator = Mockito.mock(JobFamilyValidator.class);
    RoleService roleService = new RoleService(roleDao, databaseConnector);

    JobRequest jobRequest = new JobRequest(
            "Software engineer6",
            "The specification sumarry",
            "engineering",
            "band1",
            "put some responsibilities here",
            "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

    );
    JobFamilyRequest jobFamilyRequest = new JobFamilyRequest(
            "Software engineer",
            "engineering"
    );

    Connection conn;
    @Test
    void createRole_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException, ResponsibilityTooLongException, NotURLException, JobSpecTooLongException, JobCapabilityTooLongException, JobNameTooLongException, JobBandTooLongException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobValidator.isValidJob(jobRequest)).thenReturn(true);
        Mockito.when(roleDao.createJob(jobRequest, conn)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> roleService.createJob(jobRequest));
    }

    @Test
    void createRole_shouldReturnId_whenDaoReturnsId() throws SQLException, InvalidJobException, FailedToCreateJobException {
        int expectedResult = 0;
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(roleDao.createJob(jobRequest, conn)).thenReturn(expectedResult);

        int result = roleService.createJob(jobRequest);

        assertEquals(result, expectedResult);
    }


    @Test
    void createFamily_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException, JobNameTooLongException, JobFamilyTooLongException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobFamilyValidator.isValidJobFamily(jobFamilyRequest)).thenReturn(true);
        Mockito.when(roleDao.createJobFamiliy(jobFamilyRequest, conn)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> roleService.createJobFamily(jobFamilyRequest));
    }

    @Test
    void createFamily_shouldReturnId_whenDaoReturnsId() throws SQLException,  InvalidJobFamilyException, FailedToCreateJobFamilyException {
        int expectedResult = 0;
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(roleDao.createJobFamiliy(jobFamilyRequest, conn)).thenReturn(expectedResult);

        int result = roleService.createJobFamily(jobFamilyRequest);

        assertEquals(result, expectedResult);
    }
}
