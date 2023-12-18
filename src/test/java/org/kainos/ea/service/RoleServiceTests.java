package org.kainos.ea.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.Role;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTests {

    private final DatabaseConnector databaseConnector = mock(
            DatabaseConnector.class);
    private final RoleDao roleDao = mock(RoleDao.class);
    private final RoleService roleService = new RoleService(
            roleDao, new DatabaseConnector());

    private Connection c;

    @Test
    public void getRolesShouldReturnRolesWhenDaoReturnsRoles() throws
            SQLException, FailedToGetRolesException {

        List<Role> roles = Arrays.asList(
                mock(Role.class)
        );

        when(databaseConnector.getConnection()).thenReturn(c);
        when(roleDao.getRoles(c)).thenReturn(roles);

        assertEquals(roles, roleService.getRoles());
    }
}
