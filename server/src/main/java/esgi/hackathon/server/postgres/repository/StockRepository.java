package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.StoredProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StoredProductsEntity, Long> {

    List<StoredProductsEntity> findByPlace(String place);

    @Query("SELECT 100 - COUNT(stock.id) FROM STOCKS stock WHERE stock.place = :place")
    int getAvailablePlacesInStock(@Param("place") String place);
}
