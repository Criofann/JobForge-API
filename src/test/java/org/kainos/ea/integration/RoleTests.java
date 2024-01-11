package org.kainos.ea.integration;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.JobForgeWebServiceApplication;
import org.kainos.ea.JobForgeWebServiceConfiguration;
import org.kainos.ea.cli.Role;

import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class RoleTests {
    static final DropwizardAppExtension<JobForgeWebServiceConfiguration> APP =
            new DropwizardAppExtension<>(
            JobForgeWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );

    @Test
    void getRolesShouldReturnListOfRoles() {
        List<Role> response = APP.client().target(
                "http://localhost:8080/api/job-roles")
                .request()
                .get(List.class);

        Assertions.assertTrue(response.size() > 0);
    }
}