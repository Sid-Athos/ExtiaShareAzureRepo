package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Stock;
import extia.hackathon.postgres.entity.StockEntity;

public interface StockEntityMapper {

    static Stock toDomain(StockEntity entity) {
        return Stock.builder()
                .id(entity.getId())
                .product(ProductEntityMapper.toDomain(entity.getProduct()))
                .company(CompanyEntityMapper.toDomain(entity.getCompany()))
                .expirationDate(entity.getExpirationDate())
                .size(entity.getSize())
                .build();
    }

    static StockEntity fromDomain(Stock domain) {
        System.out.println("Creation StockEntity");
        return StockEntity.builder()
                .id(domain.getId())
                .product(ProductEntityMapper.fromDomain(domain.getProduct()))
                .company(CompanyEntityMapper.fromDomain(domain.getCompany()))
                .expirationDate(domain.getExpirationDate())
                .size(domain.getSize())
                .build();
    }

}
