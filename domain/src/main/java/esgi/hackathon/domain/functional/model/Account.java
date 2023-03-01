package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

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

    Company company;

}
