package org.kainos.ea.db;


import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.cli.Role;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class RoleDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<Role> getRoles(Connection con) throws SQLException {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT RoleName, Specification,"
                + " CapabilityName "
                + "BandName, Responsibilities,"
                + " SharepointLink FROM `JobRole`;");
        List<Role> roleList = new ArrayList<>();

        while (rs.next()) {
            Role jobRole = new Role(
                    rs.getString("RoleName"),
                    rs.getString("Specification"),
                    rs.getString("Capability Name"),
                    rs.getString("Band Name"),
                    rs.getString("Responsibilities"),
                    rs.getString("SharepointLink")
            );
            roleList.add(jobRole);
        }
        return roleList;
    }


    public void createJob(JobRequest jobRequest, Connection conn)
            throws SQLException {
        Connection c =  conn;
        String insertStatment = "INSERT INTO  JobRole ("
                + "RoleName, JobFamily, Specification, CapabilityName,"
                + " Responsibilities, Sharepointlink )"
                + " VALUES(?,?,?,?,?,?)";
        PreparedStatement st = c.prepareStatement(insertStatment,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(1, jobRequest.getRoleName());
        st.setString(2, jobRequest.getJobFamily());
        st.setString(3, jobRequest.getSpecification());
        st.setString(4, jobRequest.getCapabilityName());
        st.setString(5, jobRequest.getResponsibilities());
        st.setString(6, jobRequest.getSharepointLink());


        st.executeUpdate();
        // if insert fails error will be thrown
    }

}


