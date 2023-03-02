package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.server.postgres.entity.ContainersEntity;

public interface ContainerEntityMapper {

    static Container toDomain(ContainersEntity entity) {
        return Container.builder()
                .id(entity.getId())
                .size(entity.getSize())
                .build();
    }

    static ContainersEntity fromDomain(Container domain) {
        System.out.println("Creation ContainerEntity");
        return ContainersEntity.builder()
                .id(domain.getId())
                .size(domain.getSize())
                .build();
    }

}
