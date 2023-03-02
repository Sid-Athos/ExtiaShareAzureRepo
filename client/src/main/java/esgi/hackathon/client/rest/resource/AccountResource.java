package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.AccountFindRequest;
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
    public Option<Account> find(@RequestBody AccountFindRequest request) {
        return accountFinderApi
                .findByMailAddressAndPassword(request.mailAddress(), request.password());
    }
/*

    @GetMapping(path = "/find_all")
    public List<Object> findAllAccount() {
        return accountFinderApi
                .findAll()
                .map(AccountDtoMapper::toDto);
    }

    @PostMapping(path = "/{accountId}/open_booster")
    public ResponseEntity<Object> openBooster(
            @PathVariable("accountId") UUID accountId,
            @RequestBody BoosterOpeningRequest request) {
        return boosterOpenerApi
                .openBooster(accountId, Booster.valueOf(request.booster()))
                .map(AccountDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @PostMapping(path = "/{accountId}/{cardId}/fight")
    public ResponseEntity<Object> fight(
            @PathVariable("accountId") UUID accountId,
            @PathVariable("cardId") UUID cardId,
            @RequestBody FightRequest request) {
        return fightApi
                .fight(accountId, cardId, request.opponent_account_id(), request.opponent_card_id())
                .map(AccountDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
*/
}
