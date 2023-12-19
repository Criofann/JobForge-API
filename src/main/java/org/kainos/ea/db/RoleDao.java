package org.kainos.ea.db;


import org.kainos.ea.cli.JobFamilyRequest;
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
        ResultSet rs = st.executeQuery("SELECT RoleName, Specification, "
                + "Responsibilities, SharepointLink FROM `JobRole`;");

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


    public int createJob(JobRequest jobRequest, Connection conn)
            throws SQLException {
        Connection c =  conn;
        String insertStatment = "INSERT INTO  JobRole ("
                + "RoleName, Specification, CapabilityName,"
                + " Responsibilities, Sharepointlink )"
                + " VALUES(?,?,?,?,?)";
        PreparedStatement st = c.prepareStatement(insertStatment,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(1, jobRequest.getRoleName());
        st.setString(2, jobRequest.getSpecification());
        st.setString(3, jobRequest.getCapabilityName());
        st.setString(4, jobRequest.getResponsibilities());
        st.setString(5, jobRequest.getSharepointLink());


        st.executeUpdate();


        return 0;
    }
    public int createJobFamiliy(JobFamilyRequest jobFamilyRequest, Connection c)
            throws SQLException {
        String insertStatment = "INSERT INTO  JobFamily"
                + " (JobFamily,RoleName) VALUES(?,?)";
        PreparedStatement st = c.prepareStatement(
                insertStatment, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, jobFamilyRequest.getJobFamily());
        st.setString(2, jobFamilyRequest.getRoleName());
        int affectedRows = st.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }
        int empNo = 0;

        try (ResultSet rs = st.getGeneratedKeys()) {
            if (rs.next()) {
                empNo = rs.getInt(1);
            }
        }

        return empNo;

    }
}


