package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Company;
import extia.hackathon.postgres.entity.CompanyEntity;

import java.util.stream.Collectors;

public interface CompanyEntityMapper {

    static Company toDomain(CompanyEntity entity) {
        return Company.builder()
                .id(entity.getId())
                .name(entity.getName())
                .stocksCollection(entity.getStocksCollection()
                        .stream()
                        .map(StockEntityMapper::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    static CompanyEntity fromDomain(Company domain) {
        System.out.println("Creation CompanyEntity");
        return CompanyEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .stocksCollection(domain.getStocksCollection()
                        .stream()
                        .map(StockEntityMapper::fromDomain)
                        .collect(Collectors.toList()))
                .build();
    }

}
