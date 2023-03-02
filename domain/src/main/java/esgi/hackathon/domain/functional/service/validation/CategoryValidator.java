package esgi.hackathon.domain.functional.service.validation;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Category;
import esgi.hackathon.domain.functional.model.Company;
import io.vavr.control.Validation;
import lombok.val;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface CategoryValidator {

    static Validation<ApplicationError, Category> validate(Category category) {
        val name = category.getName();
        return (name != null && name.length() > 0)
                ? Valid(category)
                : Invalid(new ApplicationError("Invalid name", null, category, null));
    }

}
