package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Long> {
}
