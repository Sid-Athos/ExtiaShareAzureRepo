package esgi.hackathon.server.postgres.adapters;

import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.domain.ports.out.StockPersistenceSpi;
import esgi.hackathon.server.postgres.mapper.StoredProductEntityMapper;
import esgi.hackathon.server.postgres.repository.StoredProductRepository;
import org.springframework.stereotype.Service;


@Service
public class StockPersistenceAdapter implements StockPersistenceSpi {

    private final StoredProductRepository storedProductRepository;


    public StockPersistenceAdapter(StoredProductRepository storedProductRepository) {
        this.storedProductRepository = storedProductRepository;
    }

    @Override
    public Long addProductInStock(StoredProduct storedProduct) {
        return storedProductRepository.save(StoredProductEntityMapper.fromDomain(storedProduct)).getId();
    }

    @Override
    public void removeProductInStock(StoredProduct storedProduct) {
        storedProductRepository.deleteById(storedProduct.getId());
    }


}
