package esgi.hackathon.bootstrap.config.domain;

import esgi.hackathon.domain.functional.service.company.CompanyCreatorService;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class DomainConfiguration {

    @Bean
    public CompanyCreatorApi companyCreationApi(CompanyPersistenceSpi spi) { return new CompanyCreatorService(spi); }

}
