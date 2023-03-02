package esgi.hackathon.server.postgres.adapters;

import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.domain.ports.out.ContainersPersistenceSpi;
import esgi.hackathon.server.postgres.entity.CompaniesEntity;
import esgi.hackathon.server.postgres.mapper.ContainerEntityMapper;
import esgi.hackathon.server.postgres.repository.ContainerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContainersPersistenceAdapter implements ContainersPersistenceSpi {

    private final ContainerRepository containerRepository;

    public ContainersPersistenceAdapter(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    @Override
    public List<Container> findAllWithProductsForCompany(Long companyId) {
        CompaniesEntity toFind = CompaniesEntity.builder().id(companyId).build();
        return containerRepository.findAllByCompany(toFind).stream().map(ContainerEntityMapper::toDomain).toList();
    }
}
