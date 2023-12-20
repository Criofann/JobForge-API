package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.kainos.ea.resources.AuthController;
import org.kainos.ea.resources.BandController;
import org.kainos.ea.resources.RoleController;

public class JobForgeWebServiceApplication
        extends Application<JobForgeWebServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new JobForgeWebServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "JobForgeWebService";
    }

    @Override
    public void
    initialize(final Bootstrap<JobForgeWebServiceConfiguration> bootstrap) {
        bootstrap.addBundle(
                new SwaggerBundle<JobForgeWebServiceConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration
            getSwaggerBundleConfiguration(
                    JobForgeWebServiceConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(final JobForgeWebServiceConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new RoleController());
        environment.jersey().register(new BandController());
        environment.jersey().register(new AuthController());
    }
}
