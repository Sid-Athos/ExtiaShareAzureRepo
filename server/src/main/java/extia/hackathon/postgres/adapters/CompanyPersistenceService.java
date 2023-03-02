package extia.hackathon.postgres.adapters;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyPersistenceService implements CompanyPersistenceSpi {
    @Override
    public Either<ApplicationError, Company> save(Company o) {
        return null;
    }

    @Override
    public List<Company> findAll() {
        return null;
    }

    @Override
    public Option<Company> findById(Long aLong) {
        return null;
    }
}
