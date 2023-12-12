package org.kainos.ea.db;

import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.cli.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<Role> getRoles() throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT RoleName, Specification, Responsibilities, SharepointLink FROM `JobRole`;");

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

    public int createJob(JobRequest jobRequest) throws SQLException {
        Connection c = databaseConnector.getConnection();
        String insertStatment = "INSERT INTO  JobRole (RoleName, Specification, CapabilityName, Responsibilities, Sharepointlink ) VALUES(?,?,?,?,?)";
        PreparedStatement st = c.prepareStatement(insertStatment, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, jobRequest.getRoleName());
        st.setString(2, jobRequest.getSpecification());
        st.setString(3, jobRequest.getCapabilityName());
        st.setString(4, jobRequest.getResponsibilities());
        st.setString(5, jobRequest.getSharepointLink());


        st.executeUpdate();


        return 0;
    }
    public int createJobFamiliy(JobFamilyRequest jobFamilyRequest) throws SQLException {
        Connection c = databaseConnector.getConnection();
        String insertStatment = "INSERT INTO  JobFamily (JobFamily,RoleName) VALUES(?,?)";
        PreparedStatement st = c.prepareStatement(insertStatment, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, jobFamilyRequest.getJobFamily());
        st.setString(2, jobFamilyRequest.getRoleName());

        st.executeUpdate();


        return 0;
    }
}