package esgi.hackathon.domain.functional.service.product;

import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.domain.ports.in.StoredProductFinderApi;
import esgi.hackathon.domain.ports.out.StoredProductPersistenceSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StoredProductFinderService implements StoredProductFinderApi {

    private final StoredProductPersistenceSpi spi;

    @Override
    public List<StoredProduct> findAllByCompany(Long companyId) {
        return spi.findAllByCompany(companyId);
    }
}
