package esgi.hackathon.domain.functional.service.company;

import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.ports.in.CompanyFinderApi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
public class CompanyFinderService implements CompanyFinderApi {

    private final CompanyPersistenceSpi spi;


    @Override
    public List<Company> findAll() {
        return spi.findAll();
    }
}
