package de.gedoplan.docker_workshop.exercise.health;

import de.gedoplan.docker_workshop.exercise.service.PersonenRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@ApplicationScoped
@Readiness
public class DbAccessCheck implements HealthCheck {

  @Inject
  PersonenRepository personenRepository;

  @Override
  public HealthCheckResponse call() {
    boolean dbIsAvailable = false;
    try {
      this.personenRepository.countAll();
      dbIsAvailable = true;
    } catch (Exception e) {
      // ignore
    }

    return HealthCheckResponse
      .named("dbIsAvailable")
      .status(dbIsAvailable)
      .build();
  }

}
