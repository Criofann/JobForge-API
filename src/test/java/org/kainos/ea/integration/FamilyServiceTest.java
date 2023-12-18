package org.kainos.ea.integration;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.JobForgeWebServiceApplication;
import org.kainos.ea.JobForgeWebServiceConfiguration;
import org.kainos.ea.cli.JobFamilyRequest;
import org.kainos.ea.cli.JobRequest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ExtendWith(DropwizardExtensionsSupport.class)
public class FamilyServiceTest {
    static final DropwizardAppExtension<JobForgeWebServiceConfiguration> APP = new DropwizardAppExtension<>(
            JobForgeWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );
    @Test
    void postFamily_shouldReturnIdOfEmployee() {
        // if data is already in the database this will fail because of primary key constraints change
        // data or delete the data form the dataBase
        JobFamilyRequest jobFamilyRequest = new JobFamilyRequest(
                "Software engineer34",
                "Jpb Family"

        );

        int id = APP.client().target("http://localhost:8080/api/job-family")
                .request()
                .post(Entity.entity(jobFamilyRequest, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(Integer.class);

        Assertions.assertNotNull(id);
    }
    @Test
    void postFamily_shouldReturnError400WithTooLongName() {

        JobFamilyRequest jobFamilyRequest = new JobFamilyRequest(
                "Software engineer names is extended to be to long",
                "job family"
        );
        Response response = APP.client().target("http://localhost:8080/api/job-family")
                .request()
                .post(Entity.entity(jobFamilyRequest, MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }
    @Test
    void postFamily_shouldReturnError400WithTooLongFamily() {

        JobFamilyRequest jobFamilyRequest = new JobFamilyRequest(
                "Software engineer12",
                "job family is limited in length to 20 characters "
        );
        Response response = APP.client().target("http://localhost:8080/api/job-family")
                .request()
                .post(Entity.entity(jobFamilyRequest, MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }

}
