package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.StoredProduct;

public interface StockCreatorApi {
    Long addProductInStock(StoredProduct storedProduct);

    void removeFromStock(StoredProduct storedProduct);

}
