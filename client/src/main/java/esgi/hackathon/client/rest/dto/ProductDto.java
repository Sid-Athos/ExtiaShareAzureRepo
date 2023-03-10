package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import esgi.hackathon.domain.functional.model.Category;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record ProductDto(
        Long id,
        String name,
        String description,
        Set<CategoryDto> categoryEntitySet
) {

}
