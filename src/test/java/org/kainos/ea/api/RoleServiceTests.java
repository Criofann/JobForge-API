package org.kainos.ea.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.cli.Role;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTests {

    DatabaseConnector databaseConnector = mock(DatabaseConnector.class);
    RoleDao roleDao = mock(RoleDao.class);
    RoleService roleService = new RoleService(roleDao, databaseConnector);

    Connection c;

   // private RoleService roleService = new RoleService(roleDao, databaseConnector);

    @Test
    public void getRoles_ShouldReturnRoles_WhenDaoReturnsRoles() throws SQLException, FailedToGetRolesException{

        List<Role> roles = Arrays.asList(
                mock(Role.class)
        );

        when(databaseConnector.getConnection()).thenReturn(c);
        when(roleDao.getRoles(c)).thenReturn(roles);

        assertEquals(roles, roleService.getRoles());
    }
}
