package esgi.hackathon.domain.functional.service.company;

import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.ports.in.CompanyFinderApi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import io.vavr.API;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.logging.Logger;

import static io.vavr.API.Left;


@RequiredArgsConstructor
public class CompanyFinderService implements CompanyFinderApi {

    private static final Logger LOGGER = Logger.getLogger(CompanyCreatorService.class.getName());

    private final CompanyPersistenceSpi spi;

    @Override
    public Company findById(Long companyId) {
        return spi.findById(companyId).get();
    }

    @Override
    public List<Company> findAll() {
        return spi.findAll();
    }
}
