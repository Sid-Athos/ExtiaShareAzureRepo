package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.StoredProduct;
import io.vavr.control.Option;

import java.util.List;

public interface StoredProductPersistenceSpi {

    List<StoredProduct> findAllByCompany(Long companyId);

    void deleteById(Long storedProductId);

    StoredProduct findById(Long storedProductId);

}
