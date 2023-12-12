package org.kainos.ea.integration;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.JobForgeWebServiceConfiguration;

import org.kainos.ea.cli.JobRequest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ExtendWith(DropwizardExtensionsSupport.class)
public class RoleServiceTest {

    static final DropwizardAppExtension<JobForgeWebServiceConfiguration> APP = new DropwizardAppExtension<>(
            JobForgeWebServiceConfiguration.class, null,
            new ResourceConfigurationSourceProvider()
    );
    @Test
    void postEmployee_shouldReturnError400WithTooLongName() {
        JobRequest jobRequest = new JobRequest(
                "Software engineer names is extended to be to long",
                "The specification sumarry",
                "Enginering",
                "band1",
                "put some responsibilities here",
                "https://kainossoftwareltd.sharepoint.com/SitePages/Home.aspx"

        );
        Response response = APP.client().target("http://localhost:8080/api/job-roles")
                .request()
                .post(Entity.entity(jobRequest, MediaType.APPLICATION_JSON_TYPE));
        Assertions.assertEquals(400, response.getStatus());
    }

}
