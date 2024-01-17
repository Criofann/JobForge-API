package org.kainos.ea.db;

import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.cli.Role;
import org.kainos.ea.client.FailedToDeleteRoleException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


    public class RoleDao {
        private DatabaseConnector databaseConnector = new DatabaseConnector();

        public Role getRoleByID(
                String role, Connection conn) throws SQLException {

            String selectStatment = "SELECT RoleName, "
                    + "Specification, CapabilityName, BandName,"
                    + " Responsibilities, SharepointLink"
                    + " FROM `JobRole` WHERE RoleName="
                    +  "VALUES(?)";
            PreparedStatement st = conn.prepareStatement(selectStatment,
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, role);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Role(
                        rs.getString("RoleName"),
                        rs.getString("Specification"),
                        rs.getString("CapabilityName"),
                        rs.getString("BandName"),
                        rs.getString("Responsibilities"),
                        rs.getString("SharepointLink")
                );
            }
            return null;
        }

        public void deleteRole(String roleName, Connection c)
                throws FailedToDeleteRoleException {

            String deleteStatement = "DELETE FROM JobRole WHERE RoleName = ?";

            try {
                PreparedStatement st = c.prepareStatement(deleteStatement);

                st.setString(1, roleName);

                st.executeUpdate();
            } catch (SQLException e) {
                throw new FailedToDeleteRoleException();
            }
        }


        public List<Role> getRoles(Connection con) throws SQLException {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT RoleName, Specification,"
                    + " CapabilityName,"
                    + "BandName, Responsibilities,"
                    + " SharepointLink FROM `JobRole`;");
            List<Role> roleList = new ArrayList<>();

            while (rs.next()) {
                Role jobRole = new Role(
                        rs.getString("RoleName"),
                        rs.getString("Specification"),
                        rs.getString("CapabilityName"),
                        rs.getString("BandName"),
                        rs.getString("Responsibilities"),
                        rs.getString("SharepointLink")
                );
                roleList.add(jobRole);
            }
            return roleList;
        }


    public void createJob(RoleRequest roleRequest, Connection conn)
            throws SQLException {
        String insertStatment = "INSERT INTO  JobRole ("
                + "RoleName, JobFamily, Specification, CapabilityName,"
                + " Responsibilities, Sharepointlink )"
                + " VALUES(?,?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(insertStatment,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(1, roleRequest.getRoleName());
        st.setString(2, roleRequest.getJobFamily());
        st.setString(3, roleRequest.getSpecification());
        st.setString(4, roleRequest.getCapabilityName());
        st.setString(5, roleRequest.getResponsibilities());
        st.setString(6, roleRequest.getSharepointLink());

        st.executeUpdate();
        // if insert fails error will be thrown
    }

}


