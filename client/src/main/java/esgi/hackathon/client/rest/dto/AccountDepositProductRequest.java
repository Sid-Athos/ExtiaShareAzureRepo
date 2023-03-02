package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record AccountDepositProductRequest(
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("expiration") Date expiration,
        @JsonProperty("quantity") int quantity,
        @JsonProperty("categories") List<CategoryDto> categories,
        @JsonProperty("containerId") Long containerId
        ) {

}
