package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Product;
import io.vavr.control.Option;

public interface ProductFinderApi {
    Option<Product> findById(Long id);
}
