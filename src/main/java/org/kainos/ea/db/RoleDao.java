package org.kainos.ea.db;


import org.kainos.ea.cli.JobRole;
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


    public void createJob(JobRole jobRole, Connection conn)
            throws SQLException {
        String insertStatment = "INSERT INTO  JobRole ("
                + "RoleName, JobFamily, Specification, CapabilityName,"
                + " Responsibilities, Sharepointlink )"
                + " VALUES(?,?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(insertStatment,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(1, jobRole.getRoleName());
        st.setString(2, jobRole.getJobFamily());
        st.setString(3, jobRole.getSpecification());
        st.setString(4, jobRole.getCapabilityName());
        st.setString(5, jobRole.getResponsibilities());
        st.setString(6, jobRole.getSharepointLink());

        st.executeUpdate();
        // if insert fails error will be thrown
    }

}


