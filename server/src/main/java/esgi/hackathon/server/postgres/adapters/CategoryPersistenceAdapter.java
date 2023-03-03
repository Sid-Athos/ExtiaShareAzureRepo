package esgi.hackathon.server.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Category;
import esgi.hackathon.domain.ports.out.CategoryPersistenceSpi;
import esgi.hackathon.server.postgres.mapper.CategoryEntityMapper;
import esgi.hackathon.server.postgres.repository.CategoryRepository;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .mapLeft(throwable -> new ApplicationError("Unable to save category", null, o, throwable))
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
    public Optional<Category> findById(Long aLong) {
        return null;
    }

}
