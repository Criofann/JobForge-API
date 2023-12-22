package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.BandRoleService;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.BandRoleDAO;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDAO;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("JobForge Dropwizard API")
@Path("/api")
public class RoleController {
    private static RoleService roleService;
    private DatabaseConnector databaseConnector;

    public RoleController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        roleService = new RoleService(new RoleDAO(), databaseConnector);
        bandRoleService = new BandRoleService(
                new BandRoleDAO(), databaseConnector);
    }
    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoles() {
        try {
            return Response.ok(roleService.getRoles()).build();
        } catch (FailedToGetRolesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    private static BandRoleService bandRoleService;
    @GET
    @Path("/BandRole")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBandRole() {
        try {
            return Response.ok(bandRoleService.getBandRole()).build();
        } catch (FailedToGetRolesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
