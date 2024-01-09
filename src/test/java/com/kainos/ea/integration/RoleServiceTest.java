package com.kainos.ea.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.client.RoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {
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
}
