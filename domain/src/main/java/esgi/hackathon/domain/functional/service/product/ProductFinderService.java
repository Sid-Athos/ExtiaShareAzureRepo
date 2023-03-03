package esgi.hackathon.domain.functional.service.product;

import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.ports.in.ProductFinderApi;
import esgi.hackathon.domain.ports.out.ProductPersistenceSpi;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductFinderService implements ProductFinderApi {

    private final ProductPersistenceSpi spi;

    @Override
    public Option<Product> findById(Long id) {
        return spi.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return spi.findAll();
    }
}
