package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Product;

import java.util.Optional;

public interface ProductFinderApi {
    Optional<Product> findById(Long id);
}
