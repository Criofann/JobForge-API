package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.JobFamilyValidator;
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
    private JobFamilyValidator jobFamilyValidator;

    public RoleController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        roleService = new RoleService(new RoleDao(), databaseConnector);
        jobValidator = new JobValidator();
        jobFamilyValidator = new JobFamilyValidator();
    }


    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoles() {
        try {
            return Response.ok(roleService.getRoles(this.databaseConnector)).build();
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
                    return Response.ok(roleService.createJob(jobRequest)).build();
                } catch (FailedToCreateJobException e) {
                    System.err.println(e.getMessage());
                    return Response.serverError().build();
                } catch (InvalidJobException e) {
                    throw new RuntimeException(e);
                }
            } else {
                return Response.status(HttpStatus.BAD_REQUEST_400).build();
            }
        } catch (SQLException | ResponsibilityTooLongException | NotURLException | JobSpecTooLongException |
                 JobNameTooLongException | JobCapabilityTooLongException | JobBandTooLongException e) {
            System.out.println(e);
            return Response.status(HttpStatus.BAD_REQUEST_400).build();
        }
    }

    @POST
    @Path("/job-family")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFamily(JobFamilyRequest jobFamilyRequest) {
        try {
            if (jobFamilyValidator.isValidJobFamily(jobFamilyRequest)) {
                try {
                    return Response.ok(roleService.createJobFamily(jobFamilyRequest)).build();
                } catch (FailedToCreateJobFamilyException e) {
                    System.err.println(e.getMessage());
                    return Response.serverError().build();
                } catch (InvalidJobFamilyException e) {
                    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
                }

            } else {
            return Response.status(HttpStatus.BAD_REQUEST_400).build();
        }
        } catch (JobNameTooLongException | JobFamilyTooLongException e) {
            System.out.println(e);
            return Response.status(HttpStatus.BAD_REQUEST_400).build();
        }
    }
}