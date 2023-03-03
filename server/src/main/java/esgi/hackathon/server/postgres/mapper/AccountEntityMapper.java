package esgi.hackathon.server.postgres.mapper;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.server.postgres.entity.AccountsEntity;

public interface AccountEntityMapper {

    static Account toDomain(AccountsEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .idNFC(entity.getIdNFC())
                .mailAddress(entity.getMailAddress())
                .password(entity.getPassword())
                .score(entity.getScore())
                .company(CompanyEntityMapper.toDomain(entity.getCompany()))
                .build();
    }

    static AccountsEntity fromDomain(Account domain) {
        return AccountsEntity.builder()
                .id(domain.getId())
                .idNFC(domain.getIdNFC())
                .mailAddress(domain.getMailAddress())
                .password(domain.getPassword())
                .score(domain.getScore())
                .company(CompanyEntityMapper.fromDomain(domain.getCompany()))
                .build();
    }

}
