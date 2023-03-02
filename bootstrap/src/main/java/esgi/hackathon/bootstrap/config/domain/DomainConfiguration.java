package esgi.hackathon.bootstrap.config.domain;

import esgi.hackathon.domain.functional.service.account.AccountCreatorService;
import esgi.hackathon.domain.functional.service.account.AccountFinderService;
import esgi.hackathon.domain.functional.service.category.CategoryCreatorService;
import esgi.hackathon.domain.functional.service.category.CategoryFinderService;
import esgi.hackathon.domain.functional.service.company.*;
import esgi.hackathon.domain.ports.in.*;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import esgi.hackathon.domain.ports.out.CategoryPersistenceSpi;
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

    @Bean
    public CategoryCreatorApi categoryCreatorApi(CategoryPersistenceSpi spi) { return new CategoryCreatorService(spi); }

    @Bean
    public CategoryFinderApi categoryFinderApi(CategoryPersistenceSpi spi) { return new CategoryFinderService(spi); }

}
