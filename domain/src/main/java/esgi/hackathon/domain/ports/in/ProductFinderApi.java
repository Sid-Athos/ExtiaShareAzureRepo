package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Product;

import java.util.Optional;

import java.util.List;

public interface ProductFinderApi {

    List<Product> findAll();
    Optional<Product> findById(Long id);
}
