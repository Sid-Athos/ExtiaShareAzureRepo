package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.StoredProduct;

import java.util.List;

public interface CompanyPersistenceSpi extends PersistenceSpi<Company, Long> {

}
