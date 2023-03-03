package esgi.hackathon.client.rest.dto;

import java.util.Date;
import java.util.List;

public record CreateStoredProductRequest(
                                         String productName,
                                         Long userId,
                                         Date expirationDate,
                                         List<CategoryDto> categoryDtoList,
                                         int size) {
}
