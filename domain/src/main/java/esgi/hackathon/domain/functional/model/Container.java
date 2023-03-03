package esgi.hackathon.domain.functional.model;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;
import lombok.With;


@Value
@Builder
public class Container {

    Long id;

    int size;

    @With @Builder.Default
    List<StoredProduct> storedProductList = List.of();

}
