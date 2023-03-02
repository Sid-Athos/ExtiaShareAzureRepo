package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.server.postgres.entity.CompaniesEntity;

public interface CompanyEntityMapper {

    static Company toDomain(CompaniesEntity entity) {
        return Company.builder()
                .id(entity.getId())
                .name(entity.getName())
                .containerList(entity.getProductsInCompany()
                        .stream()
                        .map(StockEntityMapper::toDomain)
                        .collect(Collectors.toList())
                )
                .build();
    }

    static CompaniesEntity fromDomain(Company domain) {
        System.out.println("Creation CompanyEntity");
        return CompaniesEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

}
