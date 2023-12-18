package org.kainos.ea.db;

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
        ResultSet rs = st.executeQuery("SELECT RoleName, Specification, Responsibilities, SharepointLink FROM `JobRole`;");

        List<Role> roleList = new ArrayList<>();

        while (rs.next()){
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
}