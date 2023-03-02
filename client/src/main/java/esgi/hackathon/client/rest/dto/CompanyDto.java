package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record CompanyDto(
    Long id,
    String name
) {

}
