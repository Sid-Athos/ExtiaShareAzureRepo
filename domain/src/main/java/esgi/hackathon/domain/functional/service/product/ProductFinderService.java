package esgi.hackathon.domain.functional.service.product;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.ports.in.ProductFinderApi;
import esgi.hackathon.domain.ports.out.ProductPersistenceSpi;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductFinderService implements ProductFinderApi {

    private final ProductPersistenceSpi spi;

    @Override
    public Optional<Product> findById(Long id) {
        return spi.findById(id);
    }
}
