package esgi.hackathon.client.rest.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/account")
public class AccountResource {

    @GetMapping(path = "/findAll")
    public String findAllAccount() {
        return "Working";
    }
/*
    private final AccountCreatorApi accountCreatorApi;

    private final AccountFinderApi accountFinderApi;


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createAccount(@RequestBody AccountCreationRequest request) {
        return accountCreatorApi
                .create(accountCreationToDomain(request))
                .map(AccountDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

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
