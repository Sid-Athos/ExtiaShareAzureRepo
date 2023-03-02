package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Stock;
import extia.hackathon.postgres.entity.StockEntity;

public interface StockEntityMapper {

    /**
    static Stock toDomain(StockEntity entity) {
        return Stock.builder()
                .id(entity.getId())
<<<<<<< HEAD
                //.productId(entity.getProductId().getProductId())
=======
                .product(ProductEntityMapper.toDomain(entity.getProduct()))
                .company(CompanyEntityMapper.toDomain(entity.getCompany()))
>>>>>>> 08fbe499fe8148c69e8d0ccb2491ec9e540b99a3
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

     */

}
