package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.BandService;
import org.kainos.ea.client.BandDoesNotExistException;
import org.kainos.ea.client.FailedToGetBandsException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("JobForge Dropwizard API")
@Path("/api")
public class BandController {
    private BandService bandService = new BandService();
    @GET
    @Path("/band")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBands() {
        try {
            return Response.ok(bandService.getBands()).build();
        } catch (FailedToGetBandsException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @GET
    @Path("/band/{roleName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBandByJobRole(@PathParam("roleName")String roleName) {
        try {
            return Response.ok(bandService.getBandByJobRole(roleName)).build();
        } catch (FailedToGetBandsException e) {
            System.err.println(e.getMessage());

            return  Response.serverError().build();
        } catch (BandDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}