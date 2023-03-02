package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryFinderApi {

    List<Category> findAll();

}
