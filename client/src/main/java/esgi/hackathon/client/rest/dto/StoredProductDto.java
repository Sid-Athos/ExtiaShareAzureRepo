package esgi.hackathon.client.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Product;

import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public record StoredProductDto(
        Long id,
        ProductDto product,
        ContainerDto container,
        Date expirationDate,
        int size
) {

}
