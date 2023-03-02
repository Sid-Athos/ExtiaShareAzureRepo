package esgi.hackathon.domain.functional.service.validation;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Container;
import io.vavr.control.Validation;
import lombok.val;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface ContainerValidator {

    static Validation<ApplicationError, Container> validate(Container container) {
        val size = container.getSize();
        return (
                size > 0
        )
                ? Valid(container)
                : Invalid(new ApplicationError("Invalid email or password", null, container, null));
    }

}
