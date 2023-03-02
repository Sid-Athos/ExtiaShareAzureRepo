package esgi.hackathon.domain.functional.service.company;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.service.validation.CompanyValidator;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class CompanyCreatorService implements CompanyCreatorApi {

     private static final Logger LOGGER = Logger.getLogger(CompanyCreatorService.class.getName());

     private final CompanyPersistenceSpi spi;

     @Override
     public Either<ApplicationError, Company> create(Company company) {
          return CompanyValidator.validate(company)
                  .toEither()
                  .peekLeft(
                          error -> LOGGER.warning("Company creation failed: " + error)
                  )
                  .flatMap(spi::save);
     }

}
