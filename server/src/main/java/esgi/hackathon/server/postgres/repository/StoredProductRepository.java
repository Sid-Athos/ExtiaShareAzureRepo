package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.StoredProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoredProductRepository extends JpaRepository<StoredProductsEntity, Long> {
/*
    @Query("SELECT 100 - COUNT(stock.id) FROM STOCKS stock")
    int getAvailablePlacesInStock();

 */

    @Query( value = "SELECT stock FROM STOCKS stock WHERE stock.container.company.id = :id")
    List<StoredProductsEntity> findAllByCompany(@Param("id") Long companyId);

}
