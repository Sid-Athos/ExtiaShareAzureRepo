package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.AccountCreationRequest;
import esgi.hackathon.client.rest.dto.CompanyCreationRequest;
import esgi.hackathon.client.rest.mapper.AccountDtoMapper;
import esgi.hackathon.client.rest.mapper.CompanyDtoMapper;
import esgi.hackathon.domain.ports.in.AccountCreatorApi;
import esgi.hackathon.domain.ports.in.CompanyCreatorApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/company")
public class CompanyResource {

    private final CompanyCreatorApi companyCreatorApi;

    private final AccountCreatorApi accountCreatorApi;

    @GetMapping
    public String findAllCompany() {
        return "Working";
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

}
