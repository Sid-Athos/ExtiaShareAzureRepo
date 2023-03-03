package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.UUID;

@Value
@Builder
public class Account {

    Long id;

    @Builder.Default
    @With
    String idNFC = UUID.randomUUID().toString();

    @With
    String mailAddress;

    @With
    String password;

    @With
    String logo;

    @Builder.Default
    @With
    int score = 0;

    Company company;

}
