package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.ContainersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository<ContainersEntity, Long> {

    /*
    List<ContainerEntity> findAllByCompany(CompaniesEntity company);
    */
}