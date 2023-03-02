package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import extia.hackathon.postgres.entity.CompanyEntity;

public interface CompanyEntityMapper {

    static Company toDomain(CompanyEntity entity) {
        return Company.builder()
                .id(entity.getId())
                .name(entity.getName())

                .build();
    }

    static CompanyEntity fromDomain(Company domain) {
        System.out.println("Creation CompanyEntity");
        return CompanyEntity.builder()
                .id(domain.getId())
                .name(domain.getName())

                .build();
    }

}
