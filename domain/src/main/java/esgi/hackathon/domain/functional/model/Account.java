package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.UUID;

@Value
@Builder
public class Account {

    Long id;

    @With
    String idNFC;

    @With
    String mailAddress;

    @With
    String password;

    @With
    String logo;

    @With
    int score;

    Company company;

}
