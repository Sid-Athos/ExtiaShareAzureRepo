package esgi.hackathon.client.rest.mapper;

import esgi.hackathon.client.rest.dto.AccountCreationRequest;
import esgi.hackathon.client.rest.dto.AccountDto;
import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Company;

public interface AccountDtoMapper {

    static AccountDto toDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getIdNFC(),
                account.getMailAddress(),
                account.getLogo(),
                account.getScore(),
                CompanyDtoMapper.toDto(account.getCompany())
        );
    }

    static Account accountCreationToDomain(Long companyId, AccountCreationRequest request) {
        return Account.builder()
                .password(request.password())
                .mailAddress(request.mailAddress())
                .company(Company.builder().id(companyId).build())
                .build();
    }

}
