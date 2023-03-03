package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.AccountDepositRequest;
import esgi.hackathon.client.rest.dto.AccountDto;
import esgi.hackathon.client.rest.dto.AccountFindRequest;
import esgi.hackathon.client.rest.dto.ProductDto;
import esgi.hackathon.client.rest.mapper.AccountDtoMapper;
import esgi.hackathon.client.rest.mapper.ProductDtoMapper;
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
    //private final AccountDepositApi accountDepositApi;
    private final ProductFinderApi productFinderApi;

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
    public void deposit(@PathVariable("account_id") Long accountId, @RequestBody AccountDepositRequest request) {
        Option<AccountDto> optAccountDto = accountFinderApi.findById(accountId).map(AccountDtoMapper::toDto);

        if (optAccountDto.isEmpty()){
            throw new RuntimeException("Account not found");
        }

        Option<ProductDto> optProductDto = productFinderApi.findById(request.productId()).map(ProductDtoMapper::toDto);

        if (optProductDto.isEmpty()){
            throw new RuntimeException("Product not found");
        }

        AccountDto accountDto = optAccountDto.get();

        ProductDto productDto = optProductDto.get();

        //accountDepositApi.deposit();

    }

}
