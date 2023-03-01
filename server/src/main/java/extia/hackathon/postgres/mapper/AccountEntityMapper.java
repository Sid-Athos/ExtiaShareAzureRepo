package extia.hackathon.postgres.mapper;

import esgi.hackathon.domain.functional.model.Account;
import extia.hackathon.postgres.entity.AccountEntity;

public interface AccountEntityMapper {

    static Account toDomain(AccountEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .idNFC(entity.getIdNFC())
                .mailAddress(entity.getMailAddress())
                .password(entity.getPassword())
                .company(CompanyEntityMapper.toDomain(entity.getCompany()))
                .build();
    }

    static AccountEntity fromDomain(Account domain) {
        System.out.println("Creation AccountEntity");
        return AccountEntity.builder()
                .id(domain.getId())
                .idNFC(domain.getIdNFC())
                .mailAddress(domain.getMailAddress())
                .password(domain.getPassword())
                .company(CompanyEntityMapper.fromDomain(domain.getCompany()))
                .build();
    }

}
