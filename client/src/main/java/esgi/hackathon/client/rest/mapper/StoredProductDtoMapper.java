package esgi.hackathon.client.rest.mapper;


import esgi.hackathon.client.rest.dto.ProductDto;
import esgi.hackathon.client.rest.dto.StoredProductDto;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.functional.model.StoredProduct;

public interface StoredProductDtoMapper {

    static StoredProductDto toDto(StoredProduct storedProduct) {
        return new StoredProductDto(
                storedProduct.getId(),
                ProductDtoMapper.toDto(storedProduct.getProduct()),
                ContainerDtoMapper.toDto(storedProduct.getContainer()),
                AccountDtoMapper.toDto(storedProduct.getAccount()),
                storedProduct.getExpirationDate(),
                storedProduct.getSize()
        );
    }

}
