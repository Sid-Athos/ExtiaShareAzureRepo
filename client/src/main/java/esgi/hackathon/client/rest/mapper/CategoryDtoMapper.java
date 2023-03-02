package esgi.hackathon.client.rest.mapper;


import esgi.hackathon.client.rest.dto.CategoryCreationRequest;
import esgi.hackathon.client.rest.dto.CategoryDto;
import esgi.hackathon.client.rest.dto.CompanyCreationRequest;
import esgi.hackathon.domain.functional.model.Category;

public interface CategoryDtoMapper {

    static CategoryDto toDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }

    static Category categoryCreationToDomain(CategoryCreationRequest request) {
        return Category.builder()
                .name(request.name())
                .build();
    }

    static Category toDomain(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.id())
                .name(categoryDto.name())
                .build();
    }

}
