package extia.hackathon.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import extia.hackathon.postgres.mapper.AccountEntityMapper;
import extia.hackathon.postgres.repository.AccountRepository;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static io.vavr.API.Try;

@Service
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements AccountPersistenceSpi {

    private final AccountRepository repository;

    @Override
    @Transactional
    public Either<ApplicationError, Account> save(Account o) {
        val entity = AccountEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save account", null, o, throwable))
                .map(AccountEntityMapper::toDomain);
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Option<Account> findById(Long id) {
        return repository.findAccountEntityById(id).map(AccountEntityMapper::toDomain);
    }

    @Override
    public Option<Account> findByMailAddressAndPassword(String email, String password) {
        return repository.findByMailAddressAndPassword(email, password).map(AccountEntityMapper::toDomain);
    }
}
