package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record AccountDto(
        Long id,
        String idNFC,
        String mailAddress,
        String password,

        String logo,
        int score,
        CompanyDto company
) {
}
