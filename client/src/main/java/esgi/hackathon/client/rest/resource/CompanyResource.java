package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.AccountCreationRequest;
import esgi.hackathon.client.rest.dto.AddContainerRequest;
import esgi.hackathon.client.rest.dto.CompanyCreationRequest;
import esgi.hackathon.client.rest.dto.StoredProductDto;
import esgi.hackathon.client.rest.mapper.AccountDtoMapper;
import esgi.hackathon.client.rest.mapper.CompanyDtoMapper;
import esgi.hackathon.client.rest.mapper.ContainerDtoMapper;
import esgi.hackathon.client.rest.mapper.StoredProductDtoMapper;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.ports.in.AccountCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyContainerAdderApi;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyFinderApi;
import esgi.hackathon.domain.ports.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/company")
public class CompanyResource {

    private final CompanyCreatorApi companyCreatorApi;
    private final CompanyFinderApi companyFinderApi;
    private final CompanyContainerAdderApi companyContainerAdderApi;

    private final AccountCreatorApi accountCreatorApi;

    private final StoredProductFinderApi storedProductFinderApi;

    @GetMapping
    public List<Object> findAllCompany() {
        return companyFinderApi
                .findAll()
                .stream()
                .map(CompanyDtoMapper::toDto)
                .collect(Collectors.toList());

    }

    @GetMapping(path = "/find/{company_id}")
    public Company findById(@PathVariable("company_id") Long companyId) {
        return companyFinderApi
                .findById(companyId);
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
    public Company addContainer(
            @PathVariable("company_id") Long companyId,
            @RequestBody List<AddContainerRequest> request
    ) {
        return companyContainerAdderApi
.addContainer(companyId, ContainerDtoMapper.containerCreationToDomain(request));
    }

    @GetMapping(path = "/{company_id}/products")
    public List<StoredProductDto> addContainer(
            @PathVariable("company_id") Long companyId
    ) {
        return storedProductFinderApi.findAllByCompany(companyId)
                .stream()
                .map(StoredProductDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}
