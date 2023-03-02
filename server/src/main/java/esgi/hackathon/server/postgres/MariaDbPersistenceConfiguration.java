package esgi.hackathon.server.postgres;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "extia.hackathon.postgres.repository")
@EntityScan(basePackages = "extia.hackathon.postgres.entity")
@ComponentScan(basePackages = "extia.hackathon.postgres.adapters")
@PropertySource("classpath:persistence.properties")
public class MariaDbPersistenceConfiguration {
}
