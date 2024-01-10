package org.kainos.ea.db;

import org.kainos.ea.cli.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import org.kainos.ea.cli.RoleRequest;

public class RoleDao {
    private final DatabaseConnector databaseConnector = new DatabaseConnector();
    public List<Role> getRoles(Connection conn) throws SQLException {

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT RoleName,"
                + " Specification, CapabilityName,"
                + " Responsibilities, SharepointLink FROM `JobRole`;");


        List<Role> roleList = new ArrayList<>();

        while (rs.next()) {
            Role jobRole = new Role(
                    rs.getString("RoleName"),
                    rs.getString("Specification"),
                    rs.getString("CapabilityName"),
                    rs.getString("Responsibilities"),
                    rs.getString("SharepointLink")
            );
            roleList.add(jobRole);
        }
        return roleList;
    }

    public Role getRoleByID(String role) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT RoleName,"
                + " Specification,"
                + " CapabilityName, BandName, Responsibilities, SharepointLink"
                + " FROM `JobRole` WHERE RoleName=" + "'" + role + "'");

        while (resultSet.next()) {
            return new Role(
                    resultSet.getString("RoleName"),
                    resultSet.getString("Specification"),
                    resultSet.getString("CapabilityName"),
                    resultSet.getString("BandName"),
                    resultSet.getString("Responsibilities"),
                    resultSet.getString("SharepointLink")
                    );
        }
        return null;
    }

    public void updateRole(String role, RoleRequest roleRequest)
            throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String updateStatement = "UPDATE `JobRole` SET RoleName = ?, "
                + "Specification = ?, "
                + "CapabilityName = ?, BandName = ?, Responsibilities = ?, "
                + "SharepointLink = ? WHERE RoleName = ?";

        PreparedStatement statement =
                connection.prepareStatement(updateStatement);

        statement.setString(1, roleRequest.getRoleName());
        statement.setString(2, roleRequest.getSpecification());
        statement.setString(3, roleRequest.getCapabilityName());
        statement.setString(4, roleRequest.getBandName());
        statement.setString(5, roleRequest.getResponsibilities());
        statement.setString(6, roleRequest.getSharepointLink());
        statement.setString(7, role);

        statement.executeUpdate();
    }
}
