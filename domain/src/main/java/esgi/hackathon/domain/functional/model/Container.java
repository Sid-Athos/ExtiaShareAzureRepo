package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.List;


@Value
@Builder
public class Container {

    Long id;

    int size;

    @With @Builder.Default
    List<StoredProduct> storedProductList;

}
