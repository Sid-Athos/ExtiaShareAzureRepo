package extia.hackathon.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Category;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.ports.out.CategoryPersistenceSpi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import extia.hackathon.postgres.mapper.CategoryEntityMapper;
import extia.hackathon.postgres.mapper.CompanyEntityMapper;
import extia.hackathon.postgres.repository.CategoryRepository;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static io.vavr.API.Try;

@Service
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistenceSpi {

    private final CategoryRepository repository;

    @Override
    public Either<ApplicationError, Category> save(Category o) {
        val entity = CategoryEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save account", null, o, throwable))
                .map(CategoryEntityMapper::toDomain);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll()
                .stream()
                .map(CategoryEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Option<Category> findById(Long aLong) {
        return null;
    }

}
