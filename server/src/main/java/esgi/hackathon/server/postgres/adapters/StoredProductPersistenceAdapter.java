package esgi.hackathon.server.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.domain.ports.out.StoredProductPersistenceSpi;
import esgi.hackathon.server.postgres.mapper.StoredProductEntityMapper;
import esgi.hackathon.server.postgres.repository.StoredProductRepository;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoredProductPersistenceAdapter implements StoredProductPersistenceSpi {

    private final StoredProductRepository repository;

    @Override
    public List<StoredProduct> findAllByCompany(Long companyId) {
        return repository.findAllByCompany(companyId)
                .stream()
                .map(StoredProductEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long storedProductId) {
        repository.deleteById(storedProductId);
    }

    @Override
    public Either<ApplicationError, StoredProduct> save(StoredProduct o) {
        return null;
    }

    @Override
    public List<StoredProduct> findAll() {
        return null;
    }

    @Override
    public Option<StoredProduct> findById(Long aLong) {
        return null;
    }
}
