package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Container;
import io.vavr.control.Either;

import java.util.List;

public interface CompanyContainerAdderApi {

    Company addContainer(Long companyId, List<Container> container);

}
