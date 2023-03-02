package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.CompanyCreationRequest;
import esgi.hackathon.client.rest.mapper.CompanyDtoMapper;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static esgi.hackathon.client.rest.mapper.CompanyDtoMapper.companyCreationToDomain;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/company")
public class CompanyResource {


    private final CompanyCreatorApi companyCreatorApi;

    /*
    private final CompanyFinderApi companyFinderApi;
    */


    @GetMapping(path = "/findAll")
    public String findAllCompany() {
        return "Working";
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createAccount(@RequestBody CompanyCreationRequest request) {
        return companyCreatorApi
                .create(companyCreationToDomain(request))
                .map(CompanyDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

}
