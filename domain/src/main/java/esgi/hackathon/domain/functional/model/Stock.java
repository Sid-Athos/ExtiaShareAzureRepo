package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class Stock {

    Long id;

    Product product;

    Company company;

    Date expirationDate;

    Long size;

}
