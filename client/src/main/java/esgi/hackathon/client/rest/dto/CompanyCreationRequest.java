package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CompanyCreationRequest(
    @JsonProperty("name") String name
) {
}
