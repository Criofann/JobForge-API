package org.kainos.ea.resources;

import io.swagger.annotations.Api;
<<<<<<< HEAD
import org.kainos.ea.api.RoleService;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDAO;
=======

import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.RoleRequest;

import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.client.FailedToCreateJobException;
import org.kainos.ea.client.InvalidJobException;
import org.kainos.ea.client.ValidationException;
import org.kainos.ea.core.JobValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
>>>>>>> origin/staging-branch
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

<<<<<<< HEAD
@Api("JobForge Dropwizard API")
@Path("/api")
public class RoleController {
    private static RoleService roleService;

    public RoleController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        roleService = new RoleService(new RoleDAO(), databaseConnector);
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

    @GET
    @Path("/band-role")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBandRole() {
        try {
            return Response.ok(roleService.getBandRole()).build();
        } catch (FailedToGetRolesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
=======
import java.sql.SQLException;


@Api("JobForge Dropwizard API")
@Path("/api")
public class RoleController {

    private static RoleService roleService;


    public RoleController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        roleService = new RoleService(new RoleDao(),
                databaseConnector, new JobValidator());
>>>>>>> origin/staging-branch
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
