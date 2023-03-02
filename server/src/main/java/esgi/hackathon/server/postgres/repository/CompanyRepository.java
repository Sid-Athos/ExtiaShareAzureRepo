package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.CompaniesEntity;
import io.vavr.control.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompaniesEntity, Long> {

    Option<CompaniesEntity> findCompanyEntityById(Long id);

}
