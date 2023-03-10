package esgi.hackathon.domain.functional.model;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;
import lombok.With;


@Value
@Builder
public class Company {

    Long id;

    String name;

    @With
    @Builder.Default
    List<Container> containerList = List.of();

}
