package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.StoredProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoredProductRepository extends JpaRepository<StoredProductsEntity, Long> {
    @Query("SELECT stock FROM STOCKS stock WHERE stock.container.company.id = :companyId")
    List<StoredProductsEntity> getAvailablePlacesInStock(@Param("companyId") Long companyId);

}
