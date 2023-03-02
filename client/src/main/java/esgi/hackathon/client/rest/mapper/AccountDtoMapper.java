package esgi.hackathon.client.rest.mapper;

import esgi.hackathon.client.rest.dto.AccountCreationRequest;
import esgi.hackathon.client.rest.dto.AccountDto;
import esgi.hackathon.domain.functional.model.Account;

public interface AccountDtoMapper {

    static AccountDto toDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getIdNFC(),
                account.getMailAddress(),
                account.getPassword(),
                account.getLogo(),
                account.getScore(),
                CompanyDtoMapper.toDto(account.getCompany())
        );
    }

    static Account accountCreationToDomain(AccountCreationRequest request) {
        return Account.builder()
                .password(request.password())
                .mailAddress(request.mailAddress())
                .build();
    }

}
