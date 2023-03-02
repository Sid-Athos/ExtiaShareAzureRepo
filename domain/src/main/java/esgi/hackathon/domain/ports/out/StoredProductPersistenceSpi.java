package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.StoredProduct;

import java.util.List;

public interface StoredProductPersistenceSpi extends PersistenceSpi<StoredProduct, Long>{

    List<StoredProduct> findAllByCompany(Long companyId);

}
