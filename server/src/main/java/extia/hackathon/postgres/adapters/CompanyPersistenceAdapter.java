package extia.hackathon.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import extia.hackathon.postgres.mapper.AccountEntityMapper;
import extia.hackathon.postgres.mapper.CompanyEntityMapper;
import extia.hackathon.postgres.repository.AccountRepository;
import extia.hackathon.postgres.repository.CompanyRepository;
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
public class CompanyPersistenceAdapter implements CompanyPersistenceSpi {

    private final CompanyRepository repository;

    @Override
    public Either<ApplicationError, Company> save(Company o) {
        val entity = CompanyEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save account", null, o, throwable))
                .map(CompanyEntityMapper::toDomain);
    }

    @Override
    public List<Company> findAll() {
        return repository.findAll()
                .stream()
                .map(CompanyEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Option<Company> findById(Long id) {
        return repository.findAccountEntityById(id).map(CompanyEntityMapper::toDomain);
    }
}
