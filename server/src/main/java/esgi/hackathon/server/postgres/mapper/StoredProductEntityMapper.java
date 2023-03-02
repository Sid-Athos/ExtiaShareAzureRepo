package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.server.postgres.entity.StoredProductsEntity;

public interface StoredProductEntityMapper {

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
        return StoredProductsEntity.builder()
                .id(domain.getId())
                .product(ProductEntityMapper.fromDomain(domain.getProduct()))
                .container(ContainerEntityMapper.fromDomain(domain.getContainer()))
                .expirationDate(domain.getExpirationDate())
                .size(domain.getSize())
                .build();
    }



}
