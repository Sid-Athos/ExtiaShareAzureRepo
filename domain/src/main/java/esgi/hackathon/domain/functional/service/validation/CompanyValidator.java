package esgi.hackathon.domain.functional.service.validation;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import lombok.val;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface CompanyValidator {

    static Validation<ApplicationError, Company> validate(Company company) {
        val name = company.getName();
        return (name != null && name.length() > 0)
                ? Valid(company)
                : Invalid(new ApplicationError("Invalid name", null, company, null));
    }

}
