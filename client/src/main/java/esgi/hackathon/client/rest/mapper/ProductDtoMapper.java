package esgi.hackathon.client.rest.mapper;


import esgi.hackathon.client.rest.dto.AccountWithdrawProductRequest;
import esgi.hackathon.client.rest.dto.ProductDto;
import esgi.hackathon.client.rest.dto.AccountDepositProductRequest;
import esgi.hackathon.domain.functional.model.Product;

import java.util.stream.Collectors;

public interface ProductDtoMapper {

    static ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategoryEntitySet().stream().map(CategoryDtoMapper::toDto).collect(Collectors.toSet())
        );
    }

    static Product productCreationToDomain(AccountDepositProductRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .categoryEntitySet(request.categories().stream().map(CategoryDtoMapper::toDomain).collect(Collectors.toSet()))
                .build();
    }

    static Product productWithdrawToDomain(AccountWithdrawProductRequest request) {
        return Product.builder()
                .id(request.productId())
                .build();
    }
}
