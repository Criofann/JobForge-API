package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToGetJWTSecret;
import org.kainos.ea.client.FailedToAuthenticateException;
import org.kainos.ea.cli.Login;
import org.kainos.ea.client.ServerErrorException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("JobForge Auth API")
@Path("/api")
public class AuthController {
    private static AuthService authService;

    public AuthController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        try {
            authService = new AuthService(new AuthDao(), databaseConnector);
        } catch (FailedToGetJWTSecret e){
            System.err.println("Failed to get JWT secret");
        }
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Login login) {
        try {
            return Response.ok(authService.login(login)).build();
        } catch (FailedToAuthenticateException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToGenerateTokenException |ServerErrorException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
