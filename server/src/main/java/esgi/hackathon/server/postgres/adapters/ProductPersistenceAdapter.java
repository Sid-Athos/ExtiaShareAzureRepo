package esgi.hackathon.server.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import esgi.hackathon.domain.ports.out.ProductPersistenceSpi;
import esgi.hackathon.server.postgres.mapper.CompanyEntityMapper;
import esgi.hackathon.server.postgres.mapper.ProductEntityMapper;
import esgi.hackathon.server.postgres.repository.AccountRepository;
import esgi.hackathon.server.postgres.repository.ProductRepository;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public Option<Product> findById(Long aLong) {
        return repository.findProductsEntitiesById(aLong).map(ProductEntityMapper::toDomain);
    }
}
