package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

public interface AccountCreatorApi {
    Either<ApplicationError, Account> create(Account account);
}
