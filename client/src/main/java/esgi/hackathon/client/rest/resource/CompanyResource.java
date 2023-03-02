package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.AccountCreationRequest;
import esgi.hackathon.client.rest.dto.AddContainerRequest;
import esgi.hackathon.client.rest.dto.CompanyCreationRequest;
import esgi.hackathon.client.rest.mapper.AccountDtoMapper;
import esgi.hackathon.client.rest.mapper.CompanyDtoMapper;
import esgi.hackathon.client.rest.mapper.ContainerDtoMapper;
import esgi.hackathon.domain.ports.in.AccountCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyContainerAdderApi;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyFinderApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static io.vavr.API.Left;


@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/company")
public class CompanyResource {

    private final CompanyCreatorApi companyCreatorApi;
    private final CompanyFinderApi companyFinderApi;
    private final CompanyContainerAdderApi companyContainerAdderApi;

    private final AccountCreatorApi accountCreatorApi;

    @GetMapping
    public List<Object> findAllCompany() {
        return companyFinderApi
                .findAll()
                .stream()
                .map(CompanyDtoMapper::toDto)
                .collect(Collectors.toList());

    }

    @GetMapping(path = "/find/{company_id}")
    public ResponseEntity<Object> findById(@PathVariable("company_id") Long companyId) {
        return companyFinderApi
                .findById(companyId)
                .map(CompanyDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> create(@RequestBody CompanyCreationRequest request) {
        return companyCreatorApi
                .create(CompanyDtoMapper.companyCreationToDomain(request))
                .map(CompanyDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @PostMapping(path = "/{company_id}/create_account")
    public ResponseEntity<Object> createAccount(
            @PathVariable("company_id") Long companyId,
            @RequestBody AccountCreationRequest request
    ) {
        return accountCreatorApi
                .create(AccountDtoMapper.accountCreationToDomain(companyId, request))
                .map(AccountDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @PostMapping(path = "/{company_id}/add_container")
    public ResponseEntity<Object> addContainer(
            @PathVariable("company_id") Long companyId,
            @RequestBody AddContainerRequest request
    ) {
        return companyContainerAdderApi
                .addContainer(companyId, ContainerDtoMapper.containerCreationToDomain(request))
                .map(CompanyDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

}
