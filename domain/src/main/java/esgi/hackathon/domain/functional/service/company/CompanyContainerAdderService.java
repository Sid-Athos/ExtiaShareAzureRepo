package esgi.hackathon.domain.functional.service.company;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.domain.functional.service.validation.ContainerValidator;
import esgi.hackathon.domain.ports.in.CompanyContainerAdderApi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

import static io.vavr.API.Left;


@RequiredArgsConstructor
public class CompanyContainerAdderService implements CompanyContainerAdderApi {

    private static final Logger LOGGER = Logger.getLogger(CompanyContainerAdderService.class.getName());

    private final CompanyPersistenceSpi spi;

    @Override
    public Company addContainer(Long companyId, Container container) {
        return spi.findById(companyId).get();
    }

    private Either<ApplicationError, Company> verifyAppendAndSave(Company company, Container container) {
        return ContainerValidator.validate(container)
                .toEither()
                .fold(
                        error -> Left(new ApplicationError("Container not valid", null, container, null)),
                        c -> appendAndSave(company, c)
                );
    }

    private Either<ApplicationError, Company> appendAndSave(Company company, Container container) {
        return spi.save(company.withContainerList(company.getContainerList().append(container)));
    }
}
