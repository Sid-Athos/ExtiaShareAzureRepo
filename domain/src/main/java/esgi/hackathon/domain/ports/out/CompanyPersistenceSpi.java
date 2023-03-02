package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.Company;

import java.util.List;

public interface CompanyPersistenceSpi extends PersistenceSpi<Company, Long>{

    List<Company> findAll();

}
