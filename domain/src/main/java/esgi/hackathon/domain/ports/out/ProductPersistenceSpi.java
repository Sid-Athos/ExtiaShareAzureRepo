package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.Product;
import io.vavr.control.Option;

import java.util.Optional;

public interface ProductPersistenceSpi extends PersistenceSpi<Product, Long>{

    Optional<Product> findByName(String name);
}
