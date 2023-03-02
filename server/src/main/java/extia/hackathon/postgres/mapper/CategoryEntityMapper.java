package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Category;
import extia.hackathon.postgres.entity.CategoriesEntity;

public interface CategoryEntityMapper {

    static Category toDomain(CategoriesEntity entity) {
        return Category.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    static CategoriesEntity fromDomain(Category domain) {
        System.out.println("Creation CategoryEntity");
        return CategoriesEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

}
