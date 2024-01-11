package org.kainos.ea.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToAuthenticateException;
import org.kainos.ea.cli.Login;
import org.kainos.ea.client.ServerErrorException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTests {
    private final DatabaseConnector databaseConnector =
            mock(DatabaseConnector.class);

    private final AuthDao authDao = mock(AuthDao.class);
    private final Connection c = mock(Connection.class);

    private final AuthService authService = new AuthService(authDao, databaseConnector);

    private final Login login = new Login("admin", "admin");

    @Test
    @DisplayName("Test valid login details")
    public void loginShouldReturnTokenWhenIsValidLoginReturnsTrue() throws SQLException,
            FailedToAuthenticateException, FailedToGenerateTokenException, ServerErrorException {
        String token = "24da3182-c17e-4951-a9b0-bfb763396abe";

        when(databaseConnector.getConnection()).thenReturn(c);
        when(authDao.validLogin(login, c)).thenReturn(Boolean.TRUE);
        when(authDao.generateToken(login.getUsername())).thenReturn(token);

        assertEquals(token, authService.login(login));
    }

    @Test
    @DisplayName("Test invalid login details")
    public void loginShouldReturnExceptionWhenIsValidLoginReturnsFalse() throws SQLException, ServerErrorException {
        when(databaseConnector.getConnection()).thenReturn(c);
        when(authDao.validLogin(login, c)).thenReturn(Boolean.FALSE);

        assertThrows(FailedToAuthenticateException.class, () -> authService.login(login));
    }
}
