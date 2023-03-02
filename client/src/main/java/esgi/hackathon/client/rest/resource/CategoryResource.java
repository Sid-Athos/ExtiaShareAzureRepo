package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.CategoryCreationRequest;
import esgi.hackathon.client.rest.mapper.CategoryDtoMapper;
import esgi.hackathon.client.rest.mapper.CompanyDtoMapper;
import esgi.hackathon.domain.functional.model.Category;
import esgi.hackathon.domain.ports.in.AccountCreatorApi;
import esgi.hackathon.domain.ports.in.CategoryCreatorApi;
import esgi.hackathon.domain.ports.in.CategoryFinderApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/category")
public class CategoryResource {

    private final CategoryFinderApi categoryFinderApi;

    private final CategoryCreatorApi categoryCreatorApi;


    @GetMapping
    public List<Category> findAll() {
        return categoryFinderApi
                .findAll();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> create(@RequestBody CategoryCreationRequest request) {
        return categoryCreatorApi
                .create(CategoryDtoMapper.categoryCreationToDomain(request))
                .map(CategoryDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
    
/*
    @GetMapping(path = "/find_all")
    public List<Object> findAllAccount() {
        return accountFinderApi
                .findAll()
                .map(AccountDtoMapper::toDto);
    }



*/
}
