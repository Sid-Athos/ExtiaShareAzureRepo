package esgi.hackathon.bootstrap.config.domain;

import esgi.hackathon.domain.functional.service.account.*;
import esgi.hackathon.domain.functional.service.category.CategoryCreatorService;
import esgi.hackathon.domain.functional.service.category.CategoryFinderService;
import esgi.hackathon.domain.functional.service.company.*;
import esgi.hackathon.domain.functional.service.product.ProductFinderService;
import esgi.hackathon.domain.functional.service.product.StoredProductFinderService;
import esgi.hackathon.domain.ports.in.*;
import esgi.hackathon.domain.ports.out.*;
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

    @Bean
    public ProductFinderApi productFinderApi(ProductPersistenceSpi spi) { return new ProductFinderService(spi); }

    @Bean
    public CompanyContainerAdderApi companyContainerAdderApi(CompanyPersistenceSpi spi) { return new CompanyContainerAdderService(spi); }

    @Bean
    public AccountDepositProductApi accountDepositProductApi(
            AccountPersistenceSpi accountPersistenceSpi,
            CompanyPersistenceSpi companyPersistenceSpi
    ) {
        return new AccountDepositProductService(
                companyPersistenceSpi,
                accountPersistenceSpi
        );
    }

    @Bean
    public StoredProductFinderApi storedProductFinderApi(StoredProductPersistenceSpi spi) { return new StoredProductFinderService(spi); }

    @Bean AccountPointAdderApi accountPointAdderApi(AccountPersistenceSpi spi) {
        return new AccountPointAdderService(spi);
    }

    @Bean
    public AccountStoredProductTakerApi storedProductRemoverApi(
            StoredProductPersistenceSpi spi,
            AccountPointAdderApi api
    ) {
        return new AccountStoredProductTakerService(spi, api);
    }

}
