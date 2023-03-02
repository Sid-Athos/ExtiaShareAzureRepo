package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Company {

    Long id;

    String name;

    List<StoredProduct> stocksCollection;

}
