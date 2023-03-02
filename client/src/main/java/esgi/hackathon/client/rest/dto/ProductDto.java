package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record ProductDto(
        Long id,
        String name,
        String description,
        Set<CategoryDto> categories
) {
}
