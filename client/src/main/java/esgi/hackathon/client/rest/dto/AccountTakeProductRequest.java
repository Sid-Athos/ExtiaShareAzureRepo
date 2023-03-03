package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record AccountTakeProductRequest(
        @JsonProperty("stored_product_id") Long storedProductId
)  {}
