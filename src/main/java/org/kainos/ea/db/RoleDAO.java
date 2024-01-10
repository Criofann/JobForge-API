package org.kainos.ea.db;

import org.kainos.ea.cli.BandRole;
import org.kainos.ea.cli.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private DatabaseConnector databaseConnector = new DatabaseConnector();
    public List<Role> getRoles() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT RoleName, Specification, \n"
                     + "Responsibilities, SharepointLink \n"
                     + "FROM `JobRole`;");

        List<Role> roleList = new ArrayList<>();

        while (rs.next()) {
            Role jobRole = new Role(
                    rs.getString("RoleName"),
                    rs.getString("Specification"),
                    rs.getString("Responsibilities"),
                    rs.getString("SharepointLink")
            );
            roleList.add(jobRole);
        }
        return roleList;
    }
    public List<BandRole> getBandRole() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT JobRole.RoleName, JobRole.Specification, "
                        + "JobRole.Responsibilities, "
                        + "JobRole.SharepointLink,Band.BandLevel "
                        + "FROM JobRole JOIN Band ON "
                        + "JobRole.BandName = Band.BandName;");

        List<BandRole> bandRoleList = new ArrayList<>();

        while (rs.next()) {
            BandRole bandRoleInfo = new BandRole(
                    rs.getString("RoleName"),
                    rs.getString("Specification"),
                    rs.getString("Responsibilities"),
                    rs.getString("SharepointLink"),
                    rs.getString("BandLevel")
            );
            bandRoleList.add(bandRoleInfo);
        }
        return bandRoleList;
    }
}
