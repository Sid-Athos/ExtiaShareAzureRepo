package esgi.hackathon.bootstrap.config.domain;

import esgi.hackathon.domain.functional.service.company.AccountCreatorService;
import esgi.hackathon.domain.functional.service.company.AccountFinderService;
import esgi.hackathon.domain.functional.service.company.CompanyCreatorService;
import esgi.hackathon.domain.functional.service.company.CompanyFinderService;
import esgi.hackathon.domain.ports.in.AccountCreatorApi;
import esgi.hackathon.domain.ports.in.AccountFinderApi;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyFinderApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public CompanyCreatorApi companyCreatorApi(CompanyPersistenceSpi spi) { return new CompanyCreatorService(spi); }

    @Bean
    public CompanyFinderApi companyFinderApi(CompanyPersistenceSpi spi) { return new CompanyFinderService(spi); }

    @Bean
    public AccountCreatorApi accountCreatorApi(AccountPersistenceSpi spi) { return new AccountCreatorService(spi); }

    @Bean
    public AccountFinderApi accountFinderApi(AccountPersistenceSpi spi) { return new AccountFinderService(spi); }

}
