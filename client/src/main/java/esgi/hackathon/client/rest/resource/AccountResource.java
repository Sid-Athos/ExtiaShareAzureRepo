package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.*;
import esgi.hackathon.client.rest.mapper.AccountDtoMapper;
import esgi.hackathon.client.rest.mapper.ProductDtoMapper;
import esgi.hackathon.domain.ports.in.AccountDepositProductApi;
import esgi.hackathon.domain.ports.in.AccountFinderApi;
import esgi.hackathon.domain.ports.in.ProductFinderApi;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/account")
public class AccountResource {

    private final AccountFinderApi accountFinderApi;
    private final AccountDepositProductApi accountDepositProductApi;

    @GetMapping(path = "/find")
    public Option<AccountDto> find(@RequestBody AccountFindRequest request) {
        return accountFinderApi
                .findByMailAddressAndPassword(request.mailAddress(), request.password())
                .map(AccountDtoMapper::toDto);
    }

/*
    @GetMapping(path = "/find_all")
    public List<Object> findAllAccount() {
        return accountFinderApi
                .findAll()
                .map(AccountDtoMapper::toDto);
    }



*/
    @PostMapping(path = "/{account_id}/deposit/")
    public void deposit(@PathVariable("account_id") Long accountId, @RequestBody AccountDepositProductRequest request) {

        accountDepositProductApi.deposit(accountId, ProductDtoMapper.productCreationToDomain(request), request.containerId());

    }

    @DeleteMapping(path = "/{account_id}/withdraw/")
    public void withdraw(@PathVariable("account_id") Long accountId, @RequestBody AccountWithdrawProductRequest request) {

        //accountDepositProductApi.withdraw(accountId, ProductDtoMapper.productWithdrawToDomain(request));

    }

    @GetMapping(path = "/findByMail")
    public Option<AccountDto> connect(@RequestBody AccountFindRequest request) {
        return accountFinderApi
                .findByMailAddress(request.mailAddress())
                .map(AccountDtoMapper::toDto);
    }



}
