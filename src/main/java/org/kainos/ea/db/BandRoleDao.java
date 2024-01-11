package org.kainos.ea.db;

import org.kainos.ea.cli.BandRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BandRoleDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();
    public List<BandRole> getBandRole() throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT JobRole.*, Band.BandLevel FROM JobRole\n"
                + "JOIN Band ON JobRole.BandName = Band.BandName;");

        List<BandRole> bandRoleList = new ArrayList<>();

        while (rs.next()) {
            BandRole bandRole = new BandRole(
                    rs.getString("RoleName"),
                    rs.getString("Specification"),
                    rs.getString("CapabilityName"),
                    rs.getString("Responsibilities"),
                    rs.getString("SharepointLink"),
                    rs.getString("BandLevel")
            );
            bandRoleList.add(bandRole);
        }
        return bandRoleList;
    }
}
