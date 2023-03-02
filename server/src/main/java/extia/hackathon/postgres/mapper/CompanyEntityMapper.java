package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import extia.hackathon.postgres.entity.CompanyEntity;

import java.util.stream.Collectors;

public interface CompanyEntityMapper {

    static Company toDomain(CompanyEntity entity) {
        return Company.builder()
                .id(entity.getCompanyId())
                .name(entity.getName())

                .build();
    }

    static CompanyEntity fromDomain(Company domain) {
        System.out.println("Creation CompanyEntity");
        return CompanyEntity.builder()
                .companyId(domain.getId())
                .name(domain.getName())

                .build();
    }

}
