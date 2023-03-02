package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.ContainerEntity;
import esgi.hackathon.server.postgres.entity.StoredProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository<ContainerEntity, Long> {

/*
    @Query("SELECT 100 - COUNT(stock.id) FROM STOCKS stock")
    int getAvailablePlacesInStock();
    */



}
