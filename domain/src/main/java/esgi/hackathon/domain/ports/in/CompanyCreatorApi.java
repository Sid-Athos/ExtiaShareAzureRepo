package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

@Service
public interface CompanyCreatorApi {
    Either<ApplicationError, Company> create(Company company);
}
