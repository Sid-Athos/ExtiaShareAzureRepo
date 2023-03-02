package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Category;
import extia.hackathon.postgres.entity.CategoryEntity;

public interface CategoryEntityMapper {

    static Category toDomain(CategoryEntity entity) {
        return Category.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    static CategoryEntity fromDomain(Category domain) {
        System.out.println("Creation CategoryEntity");
        return CategoryEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

}
