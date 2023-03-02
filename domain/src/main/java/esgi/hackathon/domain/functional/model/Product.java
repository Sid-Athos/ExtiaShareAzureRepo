package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Product {

    Long id;

    String name;

    String description;

    Set<Category> categoryEntitySet;

}
