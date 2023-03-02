package esgi.hackathon.domain.functional.service.category;

import esgi.hackathon.domain.functional.model.Category;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.ports.in.CategoryFinderApi;
import esgi.hackathon.domain.ports.in.CompanyFinderApi;
import esgi.hackathon.domain.ports.out.CategoryPersistenceSpi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class CategoryFinderService implements CategoryFinderApi {

    private final CategoryPersistenceSpi spi;

    @Override
    public List<Category> findAll() {
        return spi.findAll();
    }
}
