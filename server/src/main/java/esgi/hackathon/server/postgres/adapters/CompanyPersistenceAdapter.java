package esgi.hackathon.server.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import esgi.hackathon.server.postgres.mapper.CompanyEntityMapper;
import esgi.hackathon.server.postgres.mapper.StoredProductEntityMapper;
import esgi.hackathon.server.postgres.repository.CompanyRepository;
import esgi.hackathon.server.postgres.repository.ContainerRepository;
import esgi.hackathon.server.postgres.repository.StoredProductRepository;
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
public class CompanyPersistenceAdapter implements CompanyPersistenceSpi {

    private final CompanyRepository repository;
    private final ContainerRepository containerRepository;

    @Override
    public Either<ApplicationError, Company> save(Company o) {
        val entity = CompanyEntityMapper.fromDomain(o);
        containerRepository.saveAll(entity.getContainersInCompany());
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save company", null, o, throwable))
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
    public Optional<Company> findById(Long id) {
        return repository.findCompanyEntityById(id).map(CompanyEntityMapper::toDomain).toJavaOptional();
    }



}
