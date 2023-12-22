package org.kainos.ea.db;

import org.apache.commons.lang3.time.DateUtils;
import org.kainos.ea.cli.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.UUID;

public class AuthDao {
    public boolean validLogin(Login login, Connection conn) throws SQLException {
        try {
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT Password FROM `User` WHERE Email = '" + login.getUsername() + "'");
            while (rs.next()) {
                return rs.getString("password").equals(login.getPassword());
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public String generateToken(String username, Connection conn) throws SQLException {
        String token = UUID.randomUUID().toString();
        Date expiry = DateUtils.addHours(new Date(), 8);

        String insertStatement = "INSERT INTO Token(Email, Token, Expiry) VALUES(?, ?, ?)";

        PreparedStatement st = conn.prepareStatement(insertStatement);

        st.setString(1, username);
        st.setString(2, token);
        st.setTimestamp(3, new java.sql.Timestamp(expiry.getTime()));

        st.executeUpdate();

        return token;
    }

    public int registerUser(Login login, Connection conn) throws SQLException {
        String insertStatement = "INSERT INTO `User`(Username, Password, RoleID) VALUES(?, ?, ?)";

        PreparedStatement st = conn.prepareStatement(insertStatement);

        st.setString(1, login.getUsername());
        st.setString(2, login.getPassword());
        st.setInt(3, 2);

        st.executeUpdate();

        return 1;
    }
}
