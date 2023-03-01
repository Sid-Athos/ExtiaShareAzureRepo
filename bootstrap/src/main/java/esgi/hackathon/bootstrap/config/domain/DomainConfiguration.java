package esgi.hackathon.bootstrap.config.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"esgi.hackathon.server.postgres.entity"})
@EnableJpaRepositories(basePackages = {"esgi.hackathon.server.postgres.repository"})
@ComponentScan(basePackages = {"esgi.hackathon.server.postgres.adapter"})
public class DomainConfiguration {

}
