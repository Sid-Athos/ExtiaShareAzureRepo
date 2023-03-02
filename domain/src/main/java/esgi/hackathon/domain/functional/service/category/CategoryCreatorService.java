package esgi.hackathon.domain.functional.service.category;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Category;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.service.validation.CategoryValidator;
import esgi.hackathon.domain.functional.service.validation.CompanyValidator;
import esgi.hackathon.domain.ports.in.CategoryCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import esgi.hackathon.domain.ports.out.CategoryPersistenceSpi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class CategoryCreatorService implements CategoryCreatorApi {

     private static final Logger LOGGER = Logger.getLogger(CategoryCreatorService.class.getName());

     private final CategoryPersistenceSpi spi;

     @Override
     public Either<ApplicationError, Category> create(Category category) {
          return CategoryValidator.validate(category)
                  .toEither()
                  .peekLeft(
                          error -> LOGGER.warning("Company creation failed: " + error)
                  )
                  .flatMap(spi::save);
     }

}
