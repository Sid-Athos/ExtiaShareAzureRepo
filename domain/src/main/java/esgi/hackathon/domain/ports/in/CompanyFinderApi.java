package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.StoredProduct;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;

public interface CompanyFinderApi {

    Either<ApplicationError, Company> findById(Long id);

    List<Company> findAll();

    List<StoredProduct> findAllByCompany(Long companyId);

}
