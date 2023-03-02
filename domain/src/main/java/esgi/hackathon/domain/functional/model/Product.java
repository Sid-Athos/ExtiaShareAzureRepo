package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.Set;


@Value
@Builder
public class Product {

    Long id;

    String name;

    String description;

    @With
    @Builder.Default
    Set<Category> categoryEntitySet = Set.of();

}
