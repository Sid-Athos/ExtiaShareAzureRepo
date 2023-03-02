package extia.hackathon.postgres.repository;

import extia.hackathon.postgres.entity.StocksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StocksEntity, Long> {
}
