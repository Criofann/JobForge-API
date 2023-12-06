package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.RoleService;
import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;
import org.kainos.ea.client.FailedToCreateJobException;
import org.kainos.ea.client.FailedToGetRolesException;
import org.kainos.ea.client.InvalidJobException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @POST
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJobRole(JobRequest jobRequest){
        try{
            return Response.ok(roleService.createJob(jobRequest)).build();
        } catch (FailedToCreateJobException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidJobException e) {
            return   Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        }
    }
    @POST
    @Path("/job-family")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFamily(JobFamilyRequest jobFamilyRequest){
        try{
            return Response.ok(roleService.createJobFamily(jobFamilyRequest)).build();
        } catch (FailedToCreateJobFamilyException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidJobFamilyException e) {
            return   Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        }
    }
}
