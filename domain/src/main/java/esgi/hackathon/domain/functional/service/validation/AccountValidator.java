package esgi.hackathon.domain.functional.service.validation;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Company;
import io.vavr.control.Validation;
import lombok.val;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface AccountValidator {

    static Validation<ApplicationError, Account> validate(Account account) {
        val email = account.getMailAddress();
        val password = account.getPassword();
        return (
                email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$") &&
                password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$")
        )
                ? Valid(account)
                : Invalid(new ApplicationError("Invalid email or password", null, account, null));
    }

}
