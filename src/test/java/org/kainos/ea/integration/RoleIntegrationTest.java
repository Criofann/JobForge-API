package org.kainos.ea.integration;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;


import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.JobForgeWebServiceApplication;
import org.kainos.ea.JobForgeWebServiceConfiguration;

import org.kainos.ea.cli.RoleRequest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ExtendWith(DropwizardExtensionsSupport.class)
public class RoleIntegrationTest {

    static final DropwizardAppExtension<JobForgeWebServiceConfiguration> APP
            = new DropwizardAppExtension<>(
            JobForgeWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );
    @Test
    void postEmployeeShouldReturnError400WithTooLongName() {

        RoleRequest roleRequest = new RoleRequest(
                "Software engineer names is extended to be to long2",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );
        Response response = APP.client().target(
                "http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(roleRequest,
                        MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }
    @Test
    void postEmployeeShouldReturnError400WithTooLongSpec() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry but is not alowed "
                        + "to be too long beacasue that would break the "
                        + "system as their is only so"
                        + "much room assaoinged to the data base this is "
                        + "an example of a specification that"
                        + " is going to be too"
                        + "long for testing purposes this should return "
                        + "a 400 error",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );
        Response response = APP.client().target(
                "http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(roleRequest,
                        MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }
    @Test
    void postEmployeeShouldReturnError400WithTooLongCapabilityName() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry",
                "Enginering is an example of a"
                        + " capability name this should be too long",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );
        Response response = APP.client().target(
                "http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(roleRequest,
                        MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }
    @Test
    void postEmployeeShouldReturnError400WithTooLongBandName() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band name is not alowed to be too long",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );
        Response response = APP.client().target(
                "http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(roleRequest,
                        MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }
    @Test
    void postEmployeeShouldReturnError400WithTooLongResponsibilities() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer names is extended to be to long",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here but they"
                       + " are not allowed to be be too long"
                       + "as thir is only so much space asssaigned"
                       + " in the data base this should be returning"
                        + "a 400 error ",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );
        Response response = APP.client().target(
                "http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(roleRequest,
                        MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }
    @Test
    void postEmployeeShouldReturnError400WithInvalidSharePointLink() {
        RoleRequest roleRequest = new RoleRequest(
                "Software engineer names is extended to be to long",
                "Job Family",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoft"

        );
        Response response = APP.client().target(
                "http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(roleRequest,
                        MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }

    @Test
    void postRoleShouldReturnIdOfEmployee() {
        // if data is already in the database this will fail
        // because of primary key constraints change
        // data or delete the data form the dataBase
        RoleRequest roleRequest = new RoleRequest(
                "deleteme",
                "engineering",
                "The specification sumarry",
                "Engineering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"
        );

        Response response  = APP.client().target(
                "http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(roleRequest,
                        MediaType.APPLICATION_JSON_TYPE));

        Assertions.assertEquals(200, response.getStatus());
    }

}
