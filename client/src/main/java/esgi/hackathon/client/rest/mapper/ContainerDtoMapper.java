package esgi.hackathon.client.rest.mapper;


import esgi.hackathon.client.rest.dto.AddContainerRequest;
import esgi.hackathon.client.rest.dto.ContainerDto;
import esgi.hackathon.domain.functional.model.Container;

import java.util.stream.Collectors;


import java.util.List;

public interface ContainerDtoMapper {

    static ContainerDto toDto(Container container) {
        return new ContainerDto(
                container.getId(),
                container.getSize(),
                container.getStoredProductList().stream().map(StoredProductDtoMapper::toDto).collect(Collectors.toList()));
    }



    static Container toDomain(ContainerDto container) {
        return Container.builder()
                .id(container.id())
                .size(container.size())
                .build();
    }

    static List<Container> containerCreationToDomain(List<AddContainerRequest> request) {
        return request.stream().map(r -> Container.builder()
                .size(r.size())
                .build()).toList();
    }

}
