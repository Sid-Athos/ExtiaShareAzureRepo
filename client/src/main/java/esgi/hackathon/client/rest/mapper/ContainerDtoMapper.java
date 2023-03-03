package esgi.hackathon.client.rest.mapper;


import esgi.hackathon.client.rest.dto.AddContainerRequest;
import esgi.hackathon.client.rest.dto.CompanyCreationRequest;
import esgi.hackathon.client.rest.dto.CompanyDto;
import esgi.hackathon.client.rest.dto.ContainerDto;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.domain.functional.model.StoredProduct;

import java.util.List;

public interface ContainerDtoMapper {

    static ContainerDto toDto(Container container) {
        return new ContainerDto(
                container.getId(),
                container.getSize(),
                container.getStoredProductList().map(StoredProductDtoMapper::toDto).toJavaList()
        );
    }

    static List<Container> containerCreationToDomain(List<AddContainerRequest> request) {
        return request.stream().map(r -> Container.builder()
                .size(r.size())
                .build()).toList();
    }

}
