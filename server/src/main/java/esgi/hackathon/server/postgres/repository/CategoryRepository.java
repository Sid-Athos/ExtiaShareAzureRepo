package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, Long> {
}
