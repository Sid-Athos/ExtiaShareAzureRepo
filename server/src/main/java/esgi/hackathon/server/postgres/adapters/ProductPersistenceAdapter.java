package esgi.hackathon.server.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.ports.out.ProductPersistenceSpi;
import esgi.hackathon.server.postgres.mapper.ProductEntityMapper;
import esgi.hackathon.server.postgres.repository.ProductRepository;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistenceSpi {

    private final ProductRepository repository;

    @Override
    public Either<ApplicationError, Product> save(Product o) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(ProductEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return repository.findProductsEntitiesById(aLong).map(ProductEntityMapper::toDomain).toJavaOptional();
    }

    @Override
    public Optional<Product> findByName(String name) {
        return repository.findByName(name).map(ProductEntityMapper::toDomain).toJavaOptional();
    }
}
