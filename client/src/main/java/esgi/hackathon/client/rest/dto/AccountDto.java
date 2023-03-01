package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.vavr.collection.Seq;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record AccountDto(
        UUID id,
        String idNFC,
        String mail,
        String password,
        String logo
) {
}
