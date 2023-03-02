package extia.hackathon.postgres.rapositories;

import extia.hackathon.postgres.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, Long> {
}
