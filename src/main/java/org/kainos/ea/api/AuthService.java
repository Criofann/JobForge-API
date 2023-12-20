package org.kainos.ea.api;

import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToLoginException;
import org.kainos.ea.client.Login;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;

import java.sql.Connection;
import java.sql.SQLException;

public class AuthService {
    private final AuthDao authDao;
    private final DatabaseConnector databaseConnector;

    public AuthService(AuthDao authDao, DatabaseConnector databaseConnector) {
        this.authDao = authDao;
        this.databaseConnector = databaseConnector;
    }

    public String login(Login login) throws FailedToLoginException, FailedToGenerateTokenException {
        try{
            Connection conn = databaseConnector.getConnection();
            if (authDao.validLogin(login, conn)) {
                try{
                    return authDao.generateToken(login.getUsername(), conn);
                } catch (SQLException e){
                    throw new FailedToGenerateTokenException();
                }
            }
        } catch(SQLException e){
            System.err.println("Failed to get database connection");
        }
        throw new FailedToLoginException();
    }
}
