package esgi.hackathon.domain.functional.service.validation;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Container;
import io.vavr.control.Validation;
import lombok.val;

import java.util.List;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface ContainerValidator {

    static Validation<ApplicationError, List<Container>> validate(List<Container> containers) {

        containers.forEach(container -> {
            if (container.getSize() <= 0) {
                throw new IllegalArgumentException("Invalid email or password");
            }
        });

        return Valid(containers);

}

}
