package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.server.postgres.entity.ContainersEntity;
import esgi.hackathon.domain.functional.model.StoredProduct;
import java.util.stream.Collectors;

public interface ContainerEntityMapper {

    static Container toDomain(ContainersEntity entity) {
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

    static ContainersEntity fromDomain(Container domain) {
        System.out.println("Creation ContainerEntity");
        var container = new ContainersEntity();
        container.setId(domain.getId());
        container.setSize(domain.getSize());
        return container;
    }

}
