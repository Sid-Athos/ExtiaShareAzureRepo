package extia.hackathon.postgres;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "extia.hackathon.postgres.rapositories")
@EntityScan(basePackages = "extia.hackathon.postgres.entity")
public class MariaDbPersistenceConfiguration {
}
