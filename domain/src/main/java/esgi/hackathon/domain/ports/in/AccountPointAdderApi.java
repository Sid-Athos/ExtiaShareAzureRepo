package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import io.vavr.control.Either;

public interface AccountPointAdderApi {
    Either<ApplicationError, Account> addPoint(Long accountId, int amount);
}
