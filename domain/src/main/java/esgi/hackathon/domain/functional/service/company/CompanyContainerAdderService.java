package esgi.hackathon.domain.functional.service.company;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Container;
import esgi.hackathon.domain.functional.service.validation.ContainerValidator;
import esgi.hackathon.domain.ports.in.CompanyContainerAdderApi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.logging.Logger;

import static io.vavr.API.Left;


@RequiredArgsConstructor
public class CompanyContainerAdderService implements CompanyContainerAdderApi {

    private static final Logger LOGGER = Logger.getLogger(CompanyContainerAdderService.class.getName());

    private final CompanyPersistenceSpi spi;

    @Override
    public Company addContainer(Long companyId, List<Container> containers) {
        var company =  spi.findById(companyId).orElseThrow(() -> new RuntimeException("No company with id " + companyId));
         verifyAppendAndSave(company, containers);
         return company;
    }

    private Either<ApplicationError, Company> verifyAppendAndSave(Company company, List<Container> containers) {
        return ContainerValidator.validate(containers)
                .toEither()
                .fold(
                        error -> Left(new ApplicationError("One Of these container is not valid", null, containers, null)),
                        c -> appendAndSave(company, c)
                );
    }

    private Either<ApplicationError, Company> appendAndSave(Company company, List<Container> containers) {
        return spi.save(company.withContainerList(company.getContainerList().pushAll(containers)));
    }

}
