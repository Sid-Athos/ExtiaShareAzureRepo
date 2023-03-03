package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.server.postgres.entity.CompaniesEntity;
import esgi.hackathon.server.postgres.entity.ContainerEntity;

import java.util.stream.Collectors;

public interface ContainerEntityMapper {

    static Container toDomain(ContainerEntity entity) {
        return Container.builder()
                .id(entity.getId())
                .size(entity.getSize())
                .storedProductList(
                        entity
                        .getProductsInContainer()
                        .stream()
                        .map(item -> StoredProduct.builder().id(item.getId()).product(
                                Product.builder()
                                        .id(item.getProduct().getId())
                                        .name(item.getProduct().getName())
                                        .description(item.getProduct().getDescription()).build()

                        ).build()).collect(Collectors.toList())).build();
    }

    static ContainerEntity fromDomain(Container domain) {
        System.out.println("Creation ContainerEntity");
        var container = new ContainerEntity();
        container.setId(domain.getId());
        container.setSize(domain.getSize());
        return container;
    }

}
