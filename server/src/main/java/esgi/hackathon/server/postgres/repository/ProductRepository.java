package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.ProductsEntity;
import io.vavr.control.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Long> {

    Option<ProductsEntity> findProductsEntitiesById(Long id);

        Option<ProductsEntity> findByName(String name);

}
