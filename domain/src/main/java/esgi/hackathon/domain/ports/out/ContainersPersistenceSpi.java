package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.Container;

import java.util.List;

public interface ContainersPersistenceSpi {
    List<Container> findAllWithProductsForCompany(Long companyId);
}
