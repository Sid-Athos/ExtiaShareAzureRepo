package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Product;
import extia.hackathon.postgres.entity.ProductEntity;

import java.util.stream.Collectors;

public interface ProductEntityMapper {

    static Product toDomain(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .categoryEntitySet(entity.getCategoriesEntitySet().stream().map(CategoryEntityMapper::toDomain).collect(Collectors.toSet()))
                .build();
    }

    static ProductEntity fromDomain(Product domain) {
        System.out.println("Creation ProductEntity");
        return ProductEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .categoriesEntitySet(domain.getCategoryEntitySet().stream().map(CategoryEntityMapper::fromDomain).collect(Collectors.toSet()).stream().toList())
                .build();
    }

}
