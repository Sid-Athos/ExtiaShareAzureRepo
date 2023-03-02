package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryCreationRequest(
    @JsonProperty("name") String name
) {
}
