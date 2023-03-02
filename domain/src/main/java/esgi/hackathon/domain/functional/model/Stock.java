package esgi.hackathon.domain.functional.model;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class Stock {

    Long id;

    Long productId;

    Long companyId;

    Date expirationDate;

    Long size;

}
