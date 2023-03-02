package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import esgi.hackathon.domain.functional.model.Container;


import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record CompanyDto(
    Long id,
    String name,
    List<ContainerDto> containerList
) {

}
