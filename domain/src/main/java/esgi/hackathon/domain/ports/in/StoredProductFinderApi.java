package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.functional.model.StoredProduct;
import io.vavr.control.Option;

import java.util.List;

public interface StoredProductFinderApi {

    List<StoredProduct> findAllByCompany(Long companyId);

}
