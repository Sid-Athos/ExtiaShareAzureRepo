package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.AccountDto;
import esgi.hackathon.client.rest.dto.AccountFindRequest;
import esgi.hackathon.client.rest.mapper.AccountDtoMapper;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.ports.in.AccountFinderApi;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/account")
public class AccountResource {

    private final AccountFinderApi accountFinderApi;

    @GetMapping(path = "/find")
    public Option<AccountDto> find(@RequestBody AccountFindRequest request) {
        return accountFinderApi
                .findByMailAddressAndPassword(request.mailAddress(), request.password())
                .map(AccountDtoMapper::toDto);
    }

}
