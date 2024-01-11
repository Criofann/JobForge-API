package org.kainos.ea.resources;

import io.swagger.annotations.Api;

import org.kainos.ea.api.BandRoleService;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.client.FailedToDeleteRoleException;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.client.RoleDoesNotExistException;

import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.cli.RoleRequest;

import org.kainos.ea.client.FailedToCreateJobException;
import org.kainos.ea.client.InvalidJobException;
import org.kainos.ea.client.ValidationException;
import org.kainos.ea.core.JobValidator;

import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;

import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;


@Api("JobForge Dropwizard API")
@Path("/api")
public class RoleController {
    private static RoleService roleService;

    public RoleController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        roleService = new RoleService(new RoleDao(),
                databaseConnector, new JobValidator());
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

    @GET
    @Path("/job-roles/{RoleName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoleByID(@PathParam("RoleName") String roleName) {
        try {
            return Response.ok(roleService.getRoleByID(roleName)).build();
        } catch (FailedToGetRolesException e) {
            System.err.println(e.getMessage());

            return  Response.serverError().build();
        } catch (RoleDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/job-roles/{RoleName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRole(@PathParam("RoleName") String roleName) {
        try {
            roleService.deleteRole(roleName);

            return Response.ok().build();
        } catch (RoleDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToDeleteRoleException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @POST
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJobRole(RoleRequest roleRequest) {
        try {
            roleService.createJob(roleRequest);
            return Response.ok().build();

        } catch (SQLException | FailedToCreateJobException e) {
            System.err.println(e.getMessage());
            return Response.status(
                    HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        } catch (InvalidJobException | ValidationException e) {
            System.err.println(e.getMessage());
            return Response.status(HttpStatus.BAD_REQUEST_400).build();

        }
    }
}
