package org.kainos.ea.integration;


import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.JobForgeWebServiceApplication;
import org.kainos.ea.JobForgeWebServiceConfiguration;
import org.kainos.ea.cli.Login;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AuthTests {
    static final DropwizardAppExtension<JobForgeWebServiceConfiguration> APP =
            new DropwizardAppExtension<>(
                    JobForgeWebServiceApplication.class, null,
                    new ResourceConfigurationSourceProvider()
            );

    @Test
    @DisplayName("Login endpoint should fail with invalid details")
    public void loginShouldThrowExceptionWhenInvalidLogin() {
        Login invalidLogin = new Login("wrongUsername", "wrongPassword");

        Response response = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(invalidLogin, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    @DisplayName("Login endpoint should return token for successful login")
    public void loginShouldReturnTokenWhenValidLogin() {
        Login validLogin = new Login("admin", "admin");

        String token = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(validLogin, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(String.class);

        assertNotNull(token);
    }
}
