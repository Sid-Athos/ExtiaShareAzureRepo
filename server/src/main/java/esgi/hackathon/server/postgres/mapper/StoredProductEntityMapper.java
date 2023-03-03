package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.server.postgres.entity.AccountsEntity;
import esgi.hackathon.server.postgres.entity.ContainersEntity;
import esgi.hackathon.server.postgres.entity.ProductsEntity;
import esgi.hackathon.server.postgres.entity.StoredProductsEntity;

public interface StoredProductEntityMapper {

    static StoredProduct toDomain(StoredProductsEntity entity) {
        return StoredProduct.builder()
                .id(entity.getId())
                .product(ProductEntityMapper.toDomain(entity.getProduct()))
                .container(ContainerEntityMapper.toDomain(entity.getContainer()))
                .account(AccountEntityMapper.toDomain(entity.getAccount()))
                .expirationDate(entity.getExpirationDate())
                .size(entity.getSize())
                .build();
    }

    static StoredProductsEntity fromDomain(StoredProduct domain) {
        System.out.println("Creation StoredProductsEntity");
        var container = new ContainersEntity();
        var account = new AccountsEntity();
        account.setId(domain.getAccount().getId());
        container.setId(domain.getContainer().getId());
        var entity = new StoredProductsEntity();
        entity.setId(domain.getId());
        entity.setAccount(account);
        entity.setSize(domain.getSize());
        entity.setContainer(container);
        entity.setProduct(ProductsEntity.builder().id(domain.getProduct().getId()).build());
        entity.setExpirationDate(domain.getExpirationDate());
        return entity;
    }





}
