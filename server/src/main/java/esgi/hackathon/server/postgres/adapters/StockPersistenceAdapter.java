package esgi.hackathon.server.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.domain.ports.out.StockPersistenceSpi;
import esgi.hackathon.server.postgres.mapper.StockEntityMapper;
import esgi.hackathon.server.postgres.repository.AccountRepository;
import esgi.hackathon.server.postgres.repository.StoredProductRepository;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockPersistenceAdapter implements StockPersistenceSpi {

    private final StoredProductRepository storedProductRepository;


    public StockPersistenceAdapter(StoredProductRepository storedProductRepository) {
        this.storedProductRepository = storedProductRepository;
    }

    @Override
    public Long addProductInStock(StoredProduct storedProduct) {
        return storedProductRepository.save(StockEntityMapper.fromDomain(storedProduct)).getId();
    }

    @Override
    public void removeProductInStock(StoredProduct storedProduct) {
        storedProductRepository.deleteById(storedProduct.getId());
    }


}
