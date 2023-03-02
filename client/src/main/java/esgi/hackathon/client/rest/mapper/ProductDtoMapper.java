package esgi.hackathon.client.rest.mapper;

import esgi.hackathon.client.rest.dto.ProductDto;
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
}
