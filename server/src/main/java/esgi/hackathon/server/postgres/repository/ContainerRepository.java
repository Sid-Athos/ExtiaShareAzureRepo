package esgi.hackathon.server.postgres.repository;


import esgi.hackathon.server.postgres.entity.CompaniesEntity;
import esgi.hackathon.server.postgres.entity.ContainersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContainerRepository extends JpaRepository<ContainersEntity, Long> {

    @Query("SELECT container FROM CONTAINERS container WHERE container.size >= :size and container.company.id = :companyId")
    ContainersEntity findWithEnoughSpace(Integer size, Long companyId);

    List<ContainersEntity> findAllByCompany(CompaniesEntity companiesEntity);
}
