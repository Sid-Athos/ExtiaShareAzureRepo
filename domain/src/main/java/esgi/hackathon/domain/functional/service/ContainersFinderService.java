package esgi.hackathon.domain.functional.service;

import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.domain.ports.in.ContainersFinderApi;
import esgi.hackathon.domain.ports.out.ContainersPersistenceSpi;

import java.util.List;

public class ContainersFinderService implements ContainersFinderApi {

    private final ContainersPersistenceSpi containersPersistenceSpi;

    public ContainersFinderService(ContainersPersistenceSpi containersPersistenceSpi) {
        this.containersPersistenceSpi = containersPersistenceSpi;
    }

    @Override
    public List<Container> findAllWithProductsForCompany(Long companyId) {
        return containersPersistenceSpi.findAllWithProductsForCompany(companyId);
    }
}
