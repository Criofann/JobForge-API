package org.kainos.ea.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.FailedToCreateJobException;
import org.kainos.ea.client.NotURLException;
import org.kainos.ea.client.JobCapabilityTooLongException;
import org.kainos.ea.client.JobSpecTooLongException;
import org.kainos.ea.client.JobNameTooLongException;
import org.kainos.ea.client.JobBandTooLongException;
import org.kainos.ea.client.JobFamilyTooLongException;
import org.kainos.ea.client.InvalidJobException;
import org.kainos.ea.client.ResponsibilityTooLongException;
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
    private final RoleDao roleDao = Mockito.mock(RoleDao.class);
    private final DatabaseConnector databaseConnector
            = Mockito.mock(DatabaseConnector.class);
    private final JobValidator jobValidator
            = Mockito.mock(JobValidator.class);

    private final RoleService roleService
            = new RoleService(roleDao, databaseConnector);

    private final JobRequest jobRequest = new JobRequest(
            "Software engineer6",
            "Job Family",
            "The specification sumarry",
            "engineering",
            "band1",
            "put some responsibilities here",
            "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

    );
    private Connection conn;

    @Test
    void createRoleShouldThrowSqlExceptionWhenDaoThrowsSqlException()
            throws SQLException, ResponsibilityTooLongException,
            NotURLException, JobSpecTooLongException,
            JobCapabilityTooLongException,
            JobNameTooLongException, JobBandTooLongException,
            JobFamilyTooLongException {
        Mockito.when(databaseConnector.getConnection()).
                thenReturn(conn);
        Mockito.when(jobValidator.isValidJob(
                jobRequest)).thenReturn(true);
        Mockito.when(roleDao.createJob(
                jobRequest, conn)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> roleService.createJob(jobRequest));
    }

    @Test
    void createRoleShouldReturnIdWhenDaoReturnsId()
            throws SQLException, InvalidJobException,
            FailedToCreateJobException {
        int expectedResult = 0;
        Mockito.when(databaseConnector.getConnection())
                .thenReturn(conn);
        Mockito.when(roleDao.createJob(
                jobRequest, conn)).thenReturn(expectedResult);

        int result = roleService.createJob(jobRequest);

        assertEquals(result, expectedResult);
    }
}


