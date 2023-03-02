package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.server.postgres.entity.ProductsEntity;

import java.util.stream.Collectors;

public interface ProductEntityMapper {

    static Product toDomain(ProductsEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .categoryEntitySet(entity.getCategoriesEntitySet().stream().map(CategoryEntityMapper::toDomain).collect(Collectors.toSet()))
                .build();
    }

    static ProductsEntity fromDomain(Product domain) {
        System.out.println("Creation ProductEntity");
        return ProductsEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .categoriesEntitySet(domain.getCategoryEntitySet().stream().map(CategoryEntityMapper::fromDomain).collect(Collectors.toSet()).stream().toList())
                .build();
    }

}
