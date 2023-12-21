package org.kainos.ea.db;

import org.kainos.ea.cli.Band;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BandDao {
    public List<Band> getBands() throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT BandName, BandLevel, Competencies FROM `Band`;");

        List<Band> bandList = new ArrayList<>();

        while (rs.next()) {
            Band bands = new Band(
                    rs.getString("BandName"),
                    rs.getString("BandLevel"),
                    rs.getString("Competencies")
            );
            bandList.add(bands);
        }
        return bandList;
    }
    public Band getBandByJobRole(String roleName) throws SQLException {
        Connection connection = DatabaseConnector.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(
                "SELECT JobRole.RoleName, Band.BandLevel, Band.Competencies " +
                    "FROM JobRole JOIN Band ON JobRole.BandName ="
                    + " Band.BandName WHERE JobRole.RoleName = '" + roleName + "'");

        while (resultSet.next()) {
             return new Band(
                roleName,
                resultSet.getString("BandLevel"),
                resultSet.getString("Competencies")
            );
        }

        return null;
    }
}
