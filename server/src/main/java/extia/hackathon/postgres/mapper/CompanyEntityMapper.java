package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import extia.hackathon.postgres.entity.CompaniesEntity;

public interface CompanyEntityMapper {

    static Company toDomain(CompaniesEntity entity) {
        return Company.builder()
                .id(entity.getId())
                .name(entity.getName())
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
