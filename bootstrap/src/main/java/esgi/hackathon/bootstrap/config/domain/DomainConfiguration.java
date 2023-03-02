package esgi.hackathon.bootstrap.config.domain;

import esgi.hackathon.domain.functional.service.company.AccountCreatorService;
import esgi.hackathon.domain.functional.service.company.CompanyCreatorService;
import esgi.hackathon.domain.ports.in.AccountCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public CompanyCreatorApi companyCreationApi(CompanyPersistenceSpi spi) { return new CompanyCreatorService(spi); }

    @Bean
    public AccountCreatorApi accountCreationApi(AccountPersistenceSpi spi) { return new AccountCreatorService(spi); }

}
