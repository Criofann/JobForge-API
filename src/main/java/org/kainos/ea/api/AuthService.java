package org.kainos.ea.api;

import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToAuthenticateException;
import org.kainos.ea.cli.Login;
import org.kainos.ea.client.ServerErrorException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;

public class AuthService {
    private final AuthDao authDao;
    private final DatabaseConnector databaseConnector;

    public AuthService(AuthDao authDao, DatabaseConnector databaseConnector) {
        this.authDao = authDao;
        this.databaseConnector = databaseConnector;
    }

    public String login(Login login) throws FailedToAuthenticateException, FailedToGenerateTokenException,
            ServerErrorException {
        try {
            Connection conn = databaseConnector.getConnection();
            if (authDao.validLogin(login, conn)) {
                    return authDao.generateToken(login.getUsername());
            } else {
                throw new FailedToAuthenticateException("Invalid login");
            }
        } catch (SQLException e) {
            throw new ServerErrorException("Failed to get database connection");
        }
    }
}
