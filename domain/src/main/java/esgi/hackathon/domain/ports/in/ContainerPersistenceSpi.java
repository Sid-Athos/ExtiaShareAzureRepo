package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Container;

public interface ContainerPersistenceSpi {

    Container findWithEnoughSpace(Long size, Long companyId);
}
