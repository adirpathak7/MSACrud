package com.it.msaserver.service;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * A basic MicroProfile health checker for your application.
 *
 * This health checker can be adjusted as needed.
 *
 * The (test) endpoint is published: <a href="http://localhost:8080/health">http://localhost:8080/health</a>
 */
@Readiness
@ApplicationScoped
public class HealthCheckService implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("health")
                                  .up()
                                  .withData("Author", "Ivo Woltring")
                                  .withData("Website", "https://www.ivonet.nl")
                                  .build();
    }
}
