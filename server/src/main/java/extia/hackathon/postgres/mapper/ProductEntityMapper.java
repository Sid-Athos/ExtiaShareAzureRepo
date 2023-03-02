package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.functional.model.Stock;
import extia.hackathon.postgres.entity.CategoryEntity;
import extia.hackathon.postgres.entity.ProductEntity;
import extia.hackathon.postgres.entity.StockEntity;

import java.util.stream.Collectors;

public interface ProductEntityMapper {

    static Product toDomain(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .categoryEntitySet(entity.getCategoryEntitySet().stream().map(CategoryEntityMapper::toDomain).collect(Collectors.toSet()))
                .build();
    }

    static ProductEntity fromDomain(Product domain) {
        System.out.println("Creation ProductEntity");
        return ProductEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .categoryEntitySet(domain.getCategoryEntitySet().stream().map(CategoryEntityMapper::fromDomain).collect(Collectors.toSet()))
                .build();
    }

}
