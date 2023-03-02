package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.Product;
import io.vavr.control.Option;

public interface ProductPersistenceSpi extends PersistenceSpi<Product, Long>{


}
