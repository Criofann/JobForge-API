package org.kainos.ea.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.ValidationException;
import org.kainos.ea.core.JobValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.Connection;
import java.sql.SQLException;
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
            throws SQLException, ValidationException {
        Mockito.when(databaseConnector.getConnection()).
                thenReturn(conn);
        Mockito.doNothing().when(jobValidator).isValidJob(jobRequest);
        Mockito.doThrow(SQLException.class).when(
                roleDao).createJob(jobRequest, conn);
        assertThrows(SQLException.class,
                () -> roleService.createJob(jobRequest));
    }
}


