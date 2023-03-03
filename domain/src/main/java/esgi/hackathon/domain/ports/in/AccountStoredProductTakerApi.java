package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import io.vavr.control.Either;

public interface AccountStoredProductTakerApi {

    void takeStoredProduct(Long accountId, Long storedProductId);

}
