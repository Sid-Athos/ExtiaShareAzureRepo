package esgi.hackathon.client.rest.mapper;


import esgi.hackathon.client.rest.dto.CreateStoredProductRequest;
import esgi.hackathon.client.rest.dto.DeleteStoredProductRequest;
import esgi.hackathon.client.rest.dto.ProductDto;
import esgi.hackathon.client.rest.dto.StoredProductDto;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.functional.model.StoredProduct;

public interface StoredProductDtoMapper {

    static StoredProductDto toDto(StoredProduct storedProduct) {
        return new StoredProductDto(
                storedProduct.getId(),
                ProductDtoMapper.toDto(storedProduct.getProduct()),
                ContainerDtoMapper.toDto(storedProduct.getContainer()),
                storedProduct.getExpirationDate(),
                storedProduct.getSize()
        );
    }

    static StoredProduct toDomain(CreateStoredProductRequest storedProduct) {
        return StoredProduct.builder().id(null).product(Product.builder().id(storedProduct.productId()).build())
                .container(Container.builder().id(storedProduct.containerId()).build())
                .account(Account.builder().id(storedProduct.userId()).build())
                .expirationDate(storedProduct.expirationDate())
                .size(storedProduct.size())
                .build();
    }

    static StoredProduct toDomainFromDelete(DeleteStoredProductRequest storedProduct) {
        return StoredProduct.builder().id(storedProduct.id()).product(Product.builder().id(storedProduct.productId()).build())
                .container(Container.builder().id(storedProduct.containerId()).build())
                .account(Account.builder().id(storedProduct.userId()).build())
                .expirationDate(storedProduct.expirationDate())
                .size(storedProduct.size())
                .build();
    }

}
