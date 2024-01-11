package org.kainos.ea.db;


import org.kainos.ea.cli.RoleRequest;
import org.kainos.ea.cli.Role;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class RoleDao {


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


