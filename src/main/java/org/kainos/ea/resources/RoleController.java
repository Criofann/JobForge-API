package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.BandRoleService;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.client.FailedToGetRolesException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("JobForge Dropwizard API")
@Path("/api")
public class RoleController {
    private RoleService roleService = new RoleService();
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

    private BandRoleService bandRoleService = new BandRoleService();
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