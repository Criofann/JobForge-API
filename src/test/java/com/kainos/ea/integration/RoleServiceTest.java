package com.kainos.ea.integration;


import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.JobForgeWebServiceApplication;
import org.kainos.ea.JobForgeWebServiceConfiguration;
import org.kainos.ea.cli.Role;






import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.Role;
import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.client.RoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(DropwizardExtensionsSupport.class)
public class RoleServiceTest {

    static final DropwizardAppExtension<JobForgeWebServiceConfiguration> APP =
            new DropwizardAppExtension<>(
                    JobForgeWebServiceApplication.class, null,
                    new ResourceConfigurationSourceProvider()
            );


    RoleDao roleDao = Mockito.mock(RoleDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);

    RoleService roleService
            = new RoleService(roleDao, databaseConnector);

    private final RoleRequest roleRequest = new RoleRequest(
            "Software engineer6",
            "Job Specification",
            "A Capability",
            "Band",
            "A lot of responsibilities",
            "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
    );
    String roleName = "name";


    Connection conn;



    @Test
    void deleteRoleShouldDeleteRole() {
        Role role = new Role("Software Engineer","Develop code","Engineering","Write and test code", "Sharepoint");


        String name = APP.client().target("http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(role, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(String.class);




    }
}
