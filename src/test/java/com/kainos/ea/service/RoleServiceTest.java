package com.kainos.ea.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.Role;
import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.client.FailedToDeleteRoleException;
import org.kainos.ea.client.RoleDoesNotExistException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

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

    Connection conn;

    @Test
    void deleteRoleShouldThrowFailedToDeleteExceptionWhenDaoThrowsFailedToDeleteException()
            throws SQLException, FailedToDeleteRoleException {
        String roleName = "name";
        Role mockRoleResponse = new Role("Software Engineer","Develop code","Engineering","Write and test code", "Sharepoint");

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(roleDao.getRoleByID(roleName, conn)).thenReturn(mockRoleResponse);
        Mockito.doThrow(FailedToDeleteRoleException.class).when(roleDao).deleteRole(roleName, conn);

        assertThrows(FailedToDeleteRoleException.class,
                () -> roleService.deleteRole(roleName));

    }
}