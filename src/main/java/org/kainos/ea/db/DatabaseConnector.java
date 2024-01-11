package org.kainos.ea.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {


    private static Connection connection;


    public Connection getConnection()
            throws SQLException {
        String user;
        String password;
        String host;
        String name;

        if (connection != null
                && !connection.isClosed()) {
            return connection;
        }

        try {
            user = System.getenv("DB_USERNAME");
            password = System.getenv("DB_PASSWORD");
            host = System.getenv("DB_HOST");
            name = System.getenv("DB_NAME");
            if (user == null || password == null
                    || host == null || name == null) {

                throw new IllegalArgumentException(
                        "Environment variables must be set for "
                                + "DB_USERNAME, DB_PASSWORD, "
                                + "DB_HOST, and DB_NAME."
                );
            }
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + host + "/" + name
                            + "?useSSL=false",
                    user, password);
            return connection;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new SQLException();
        }
    }

}
