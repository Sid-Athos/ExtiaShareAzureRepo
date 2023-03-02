package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.CompaniesEntity;
import esgi.hackathon.server.postgres.entity.ContainerEntity;
import esgi.hackathon.server.postgres.entity.StoredProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainerRepository extends JpaRepository<ContainerEntity, Long> {

    /*
    List<ContainerEntity> findAllByCompany(CompaniesEntity company);
    */
}