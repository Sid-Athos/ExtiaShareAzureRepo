package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.server.postgres.entity.ContainerEntity;
import esgi.hackathon.server.postgres.entity.ProductsEntity;
import esgi.hackathon.server.postgres.entity.StoredProductsEntity;

public interface StockEntityMapper {

    static StoredProduct toDomain(StoredProductsEntity entity) {
        return StoredProduct.builder()
                .id(entity.getId())
                .product(ProductEntityMapper.toDomain(entity.getProduct()))
                .container(ContainerEntityMapper.toDomain(entity.getContainer()))
                .expirationDate(entity.getExpirationDate())
                .size(entity.getSize())
                .build();
    }

    static StoredProductsEntity fromDomain(StoredProduct domain) {
        System.out.println("Creation StoredProductsEntity");
        var container = new ContainerEntity();
        container.setId(domain.getContainer().getId());
        var entity = new StoredProductsEntity();
        entity.setId(domain.getId());
        entity.setSize(domain.getSize());
        entity.setContainer(container);
        entity.setProduct(ProductsEntity.builder().id(domain.getProduct().getId()).build());
        entity.setExpirationDate(domain.getExpirationDate());


        return entity;
    }



}
