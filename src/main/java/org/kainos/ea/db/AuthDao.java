package org.kainos.ea.db;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.time.DateUtils;
import org.kainos.ea.cli.Login;
import org.kainos.ea.client.FailedToGetJWTSecret;
import org.kainos.ea.client.FailedToAuthenticateException;
import org.kainos.ea.client.ServerErrorException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.Date;

public class AuthDao {
    private final Key hmacKey;
    //Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(32, 64, 1, 15 * 1024, 2);
    private final Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);

    public AuthDao() throws FailedToGetJWTSecret {
        try {
            hmacKey = new SecretKeySpec(Base64.getDecoder().decode(System.getenv("JWT_SECRET")),
                    SignatureAlgorithm.HS256.getJcaName());
        } catch (Exception e) {
            throw new FailedToGetJWTSecret();
        }
    }

    public boolean validLogin(Login login, Connection conn) throws ServerErrorException {
        try {
            Statement st = conn.createStatement();
            String query = "SELECT Password FROM `User` WHERE Email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, login.getUsername());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return encoder.matches(login.getPassword(), rs.getString("password"));
            }
            return false;
        } catch (SQLException e) {
            throw new ServerErrorException("SQL Exception");
        }
    }

    public String generateToken(String username) {
        Date currentDate = new Date();
        return Jwts.builder()
                .claim("username", username)
                .setIssuedAt(currentDate)
                .setExpiration(DateUtils.addHours(currentDate, 8))
                .signWith(hmacKey)
                .compact();
    }

    public Claims parseToken(String token) throws FailedToAuthenticateException, ServerErrorException {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new FailedToAuthenticateException("Expired token");
        } catch (MalformedJwtException e) {
            throw new ServerErrorException("Invalid token");
        }
    }
}
