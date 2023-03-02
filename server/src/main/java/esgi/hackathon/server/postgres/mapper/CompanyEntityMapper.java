package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.server.postgres.entity.CompaniesEntity;
import io.vavr.collection.List;

public interface CompanyEntityMapper {

    static Company toDomain(CompaniesEntity entity) {
        return Company.builder()
                .id(entity.getId())
                .name(entity.getName())
                .containerList(List.ofAll(entity.getContainersInCompany().stream().map(ContainerEntityMapper::toDomain)))
                .build();
    }

    static CompaniesEntity fromDomain(Company domain) {
        System.out.println("Creation CompanyEntity");
        return CompaniesEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .containersInCompany(domain.getContainerList().map(ContainerEntityMapper::fromDomain).asJavaMutable())
                .build();
    }

}
