package org.kainos.ea.db;

import org.kainos.ea.cli.Role;
import org.kainos.ea.client.FailedToDeleteRoleException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class RoleDao {
        private DatabaseConnector databaseConnector = new DatabaseConnector();
        public List<Role> getRoles() throws SQLException {
            Connection c = databaseConnector.getConnection();

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT RoleName, Specification, CapabilityName, Responsibilities, SharepointLink FROM `JobRole`;");

            List<Role> roleList = new ArrayList<>();

            while (rs.next()){
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

    public Role getRoleByID(String role, Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT RoleName, Specification, CapabilityName, BandName, Responsibilities, SharepointLink" +
                " FROM `JobRole` WHERE RoleName=" + "'" + role + "'");

        while (resultSet.next()) {
            return new Role(
                    resultSet.getString("RoleName"),
                    resultSet.getString("Specification"),
                    resultSet.getString("CapabilityName"),
                    resultSet.getString("Responsibilities"),
                    resultSet.getString("SharepointLink")
            );
        }
        return null;
    }

    public void deleteRole(String roleName, Connection c) throws FailedToDeleteRoleException {

        String deleteStatement = "DELETE FROM JobRole WHERE RoleName = ?";

        try {
            PreparedStatement st = c.prepareStatement(deleteStatement);

            st.setString(1, roleName);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new FailedToDeleteRoleException();
        }
    }
}
