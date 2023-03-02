package extia.hackathon.postgres.repository;

import extia.hackathon.postgres.entity.AccountsEntity;
import extia.hackathon.postgres.entity.CompanyEntity;
import io.vavr.control.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    Option<CompanyEntity> findAccountEntityById(Long id);

}
