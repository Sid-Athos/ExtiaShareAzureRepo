package esgi.hackathon.client.rest.dto;

import java.util.Date;

public record DeleteStoredProductRequest(
        Long id,
        Long productId,
        Long containerId,
        Long userId,
        Date expirationDate,
        int size
) {
}
