package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.server.postgres.entity.CompaniesEntity;
import esgi.hackathon.server.postgres.entity.ContainerEntity;

public interface ContainerEntityMapper {

    static Container toDomain(ContainerEntity entity) {
        return Container.builder()
                .id(entity.getId())
                .size(entity.getSize())
                .build();
    }

    static ContainerEntity fromDomain(Container domain) {
        System.out.println("Creation ContainerEntity");
        var container = new ContainerEntity();
        container.setId(domain.getId());
        container.setSize(domain.getSize());

        return container;
    }

}
