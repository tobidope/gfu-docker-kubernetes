package de.gedoplan.docker_workshop.exercise.health;

import de.gedoplan.docker_workshop.exercise.service.PersonenRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@ApplicationScoped
@Liveness
public class AppDeployedCheck implements HealthCheck {

  @Inject
  PersonenRepository personenRepository;

  @Override
  public HealthCheckResponse call() {
    return HealthCheckResponse
      .named("appIsDeployed")
      .up()
      .build();
  }

}
