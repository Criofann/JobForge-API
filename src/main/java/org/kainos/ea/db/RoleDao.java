package org.kainos.ea.db;

import io.swagger.annotations.Api;
import org.kainos.ea.cli.Role;

import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
    public List<Role> getRoles() throws SQLException {
        Connection c = DatabaseConnector.getConnection();

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
