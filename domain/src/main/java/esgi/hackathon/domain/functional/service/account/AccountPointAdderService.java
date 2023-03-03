package esgi.hackathon.domain.functional.service.account;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.ports.in.AccountPointAdderApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

import static io.vavr.API.Left;

@RequiredArgsConstructor
public class AccountPointAdderService implements AccountPointAdderApi {

    private static final Logger LOGGER = Logger.getLogger(AccountPointAdderService.class.getName());

    private final AccountPersistenceSpi spi;

    public Either<ApplicationError, Account> addPoint(Long accountId, int amount) {
        return spi.findById(accountId)
                .onEmpty(() -> LOGGER.warning("Account not found with id : " + accountId))
                .fold(
                        () -> Left(new ApplicationError("No account", null, accountId, null)),
                        account -> appendAndSave(account, amount)
                );
    }

    private Either<ApplicationError, Account> appendAndSave(Account account, int amount) {
        return spi.save(account.withScore(account.getScore() + amount));
    }
}
