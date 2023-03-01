package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Stock;
import extia.hackathon.postgres.entity.StockEntity;

public interface StockEntityMapper {

    static Stock toDomain(StockEntity entity) {
        return Stock.builder()
                .id(entity.getId())
                .companyId(entity.getCompanyId())
                .productId(entity.getProductId())
                .expirationDate(entity.getExpirationDate())
                .build();
    }

    static StockEntity fromDomain(Stock domain) {
        System.out.println("Creation StockEntity");
        return StockEntity.builder()
                .id(domain.getId())
                .companyId(domain.getCompanyId())
                .productId(domain.getProductId())
                .expirationDate(domain.getExpirationDate())
                .build();
    }

}
