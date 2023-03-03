package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.*;
import esgi.hackathon.client.rest.mapper.AccountDtoMapper;
import esgi.hackathon.client.rest.mapper.ProductDtoMapper;
import esgi.hackathon.domain.ApplicationError;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.ports.in.AccountDepositProductApi;
import esgi.hackathon.domain.ports.in.AccountFinderApi;
import esgi.hackathon.domain.ports.in.AccountNFCConnectionApi;
import esgi.hackathon.domain.ports.in.AccountStoredProductTakerApi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/account")
public class AccountResource {

    private final AccountNFCConnectionApi accountNFCConnectionApi;
    private final AccountFinderApi accountFinderApi;
    private final AccountDepositProductApi accountDepositProductApi;

    @PostMapping(path = "/find")
    public Option<AccountDto> find(@RequestBody AccountFindRequest request) {
        return accountFinderApi
                .findByMailAddressAndPassword(request.mailAddress(), request.password())
                .map(AccountDtoMapper::toDto);
    }

    @PostMapping(path = "/{account_id}/deposit/")
    public void deposit(@PathVariable("account_id") Long accountId, @RequestBody AccountDepositProductRequest request) {
        accountDepositProductApi.deposit(accountId, ProductDtoMapper.productCreationToDomain(request), request.containerId());
    }


    @GetMapping(path = "/findByMail/{mailAddress}")
    public Option<AccountDto> connect(@PathVariable("mailAddress") String mailAddress){
        return accountFinderApi
                .findByMailAddress(mailAddress)
                .map(AccountDtoMapper::toDto);
    }

    @PostMapping(path = "/connection_nfc")
    public Option<AccountDto> connectionByNFC(@RequestBody AccountNFCConnectionRequest request) {
        return accountNFCConnectionApi
                .connect(request.idNFC())
                .map(AccountDtoMapper::toDto);
    }


}
