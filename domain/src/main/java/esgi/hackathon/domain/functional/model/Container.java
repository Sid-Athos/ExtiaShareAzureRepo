package esgi.hackathon.domain.functional.model;

import lombok.*;

import java.util.List;


@Builder
@Getter
public class Container {

    Long id;
    @With
    int size;

    @With @Builder.Default
    List<StoredProduct> storedProductList;

}
