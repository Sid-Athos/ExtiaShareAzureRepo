package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.functional.model.StoredProduct;

public interface StockPersistenceSpi {
    Long addProductInStock(StoredProduct storedProduct);

    void removeProductInStock(StoredProduct storedProduct);
}
