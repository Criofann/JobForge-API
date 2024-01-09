package org.kainos.ea.resources;

import io.swagger.annotations.Api;

import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.JobRequest;

import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.client.FailedToCreateJobException;
import org.kainos.ea.client.NotURLException;
import org.kainos.ea.client.JobCapabilityTooLongException;
import org.kainos.ea.client.JobSpecTooLongException;
import org.kainos.ea.client.JobNameTooLongException;
import org.kainos.ea.client.JobBandTooLongException;
import org.kainos.ea.client.JobFamilyTooLongException;
import org.kainos.ea.client.InvalidJobException;
import org.kainos.ea.client.ResponsibilityTooLongException;
import org.kainos.ea.core.JobValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RoleDao;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;


@Api("JobForge Dropwizard API")
@Path("/api")
public class RoleController {


    private static RoleService roleService;
    private DatabaseConnector databaseConnector;

    private JobValidator jobValidator;


    public RoleController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        roleService = new RoleService(new RoleDao(), databaseConnector);
        jobValidator = new JobValidator();
    }


    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoles() {
        try {
            DatabaseConnector databaseConnector = new DatabaseConnector();

            return Response.ok(roleService.getRoles(databaseConnector)).build();
        } catch (FailedToGetRolesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @POST
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJobRole(JobRequest jobRequest) {
        try {
            if (jobValidator.isValidJob(jobRequest)) {
                try {
                    return Response.ok(
                            roleService.createJob(jobRequest)).build();
                } catch (FailedToCreateJobException e) {
                    System.err.println(e.getMessage());
                    return Response.serverError().build();
                } catch (InvalidJobException e) {
                    throw new RuntimeException(e);
                }
            } else {
                return Response.status(HttpStatus.BAD_REQUEST_400).build();
            }
        } catch (SQLException | ResponsibilityTooLongException
                 | NotURLException | JobSpecTooLongException
                 | JobNameTooLongException | JobCapabilityTooLongException
                 | JobBandTooLongException e) {
            System.out.println(e);
            return Response.status(HttpStatus.BAD_REQUEST_400).build();
        } catch (JobFamilyTooLongException e) {
            throw new RuntimeException(e);
        }
    }

}
