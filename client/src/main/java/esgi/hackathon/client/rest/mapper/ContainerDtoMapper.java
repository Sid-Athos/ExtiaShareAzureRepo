package esgi.hackathon.client.rest.mapper;


import esgi.hackathon.client.rest.dto.AddContainerRequest;
import esgi.hackathon.client.rest.dto.ContainerDto;
import esgi.hackathon.domain.functional.model.Container;


public interface ContainerDtoMapper {

    static ContainerDto toDto(Container container) {
        return new ContainerDto(
                container.getId(),
                container.getSize(),
                container.getStoredProductList().map(StoredProductDtoMapper::toDto).toJavaList()
        );
    }

    static Container containerCreationToDomain(AddContainerRequest request) {
        return Container.builder()
                .size(request.size())
                .build();
    }

}
