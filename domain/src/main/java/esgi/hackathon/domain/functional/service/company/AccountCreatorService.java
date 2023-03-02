package esgi.hackathon.domain.functional.service.company;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.service.validation.AccountValidator;
import esgi.hackathon.domain.functional.service.validation.CompanyValidator;
import esgi.hackathon.domain.ports.in.AccountCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class AccountCreatorService implements AccountCreatorApi {

     private static final Logger LOGGER = Logger.getLogger(AccountCreatorService.class.getName());

     private final AccountPersistenceSpi spi;

     @Override
     public Either<ApplicationError, Account> create(Account account) {
          return AccountValidator.validate(account)
                  .toEither()
                  .peekLeft(
                          error -> LOGGER.warning("Account creation failed: " + error)
                  )
                  .flatMap(spi::save);
     }

}
