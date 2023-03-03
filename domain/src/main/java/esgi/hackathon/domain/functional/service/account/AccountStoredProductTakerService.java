package esgi.hackathon.domain.functional.service.account;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.domain.ports.in.AccountPointAdderApi;
import esgi.hackathon.domain.ports.in.AccountStoredProductTakerApi;
import esgi.hackathon.domain.ports.out.StoredProductPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

import static io.vavr.API.Left;
import static io.vavr.API.Right;

@RequiredArgsConstructor
public class AccountStoredProductTakerService implements AccountStoredProductTakerApi {

    private static final Logger LOGGER = Logger.getLogger(AccountStoredProductTakerService.class.getName());

    private final StoredProductPersistenceSpi storedProductPersistenceSpi;

    private final AccountPointAdderApi accountPointAdderApi;

    @Override
    public void takeStoredProduct(Long accountId, Long storedProductId) {
        storedProductPersistenceSpi.findById(storedProductId)
                .onEmpty(() -> LOGGER.warning("Stored product not found with id : " + storedProductId))
                .fold(
                        () -> Left(new ApplicationError("No stored product", null, storedProductId, null)),
                        storedProduct -> doRecompenseAndSaveAndDelete(accountId, storedProduct)
                );
    }

    private Either<ApplicationError, Account> doRecompenseAndSaveAndDelete(Long accountId, StoredProduct storedProduct) {
        storedProductPersistenceSpi.deleteById(storedProduct.getId());
        return accountPointAdderApi.addPoint(storedProduct.getAccount().getId(), 10);
    }
}
