package extia.hackathon.postgres.repository;

import extia.hackathon.postgres.entity.StocksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StocksEntity, Long> {


    @Query("SELECT 100 - COUNT(stock.id) FROM STOCKS stock")
    int getAvailablePlacesInStock();
}
