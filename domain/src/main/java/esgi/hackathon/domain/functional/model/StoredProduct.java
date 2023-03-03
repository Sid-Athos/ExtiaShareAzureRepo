package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class StoredProduct {

    Long id;

    Product product;

    Container container;

    Date expirationDate;

    int size;

}
