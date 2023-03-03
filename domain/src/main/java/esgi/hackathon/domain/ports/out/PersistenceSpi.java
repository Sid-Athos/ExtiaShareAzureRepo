package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import io.vavr.control.Either;

import java.util.List;
import java.util.Optional;

public interface PersistenceSpi<T, ID> {
    Either<ApplicationError, T> save(T o);

    List<T> findAll();

    Optional<T> findById(ID id);
}
