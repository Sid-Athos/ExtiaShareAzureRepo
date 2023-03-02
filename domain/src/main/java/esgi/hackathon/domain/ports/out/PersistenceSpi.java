package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.ApplicationError;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;


public interface PersistenceSpi<T, ID> {
    Either<ApplicationError, T> save(T o);

    List<T> findAll();

    Option<T> findById(ID id);
}
