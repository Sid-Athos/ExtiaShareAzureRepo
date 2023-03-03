package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Product;
import io.vavr.control.Option;

import java.util.List;

public interface ProductFinderApi {
    Option<Product> findById(Long id);

    List<Product> findAll();
}
