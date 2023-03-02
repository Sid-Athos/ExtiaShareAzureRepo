package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class Company {

    Long id;

    String name;

    List<Stock> stocksCollection;

}
