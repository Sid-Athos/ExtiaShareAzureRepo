package esgi.hackathon.domain.functional.service.account;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Company;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.ports.in.AccountDepositProductApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import esgi.hackathon.domain.ports.out.CompanyPersistenceSpi;
import lombok.RequiredArgsConstructor;

import java.awt.*;

@RequiredArgsConstructor
public class AccountDepositProductService implements AccountDepositProductApi {

    private final CompanyPersistenceSpi companySpi;
    private final AccountPersistenceSpi accountSpi;

    @Override
    public void deposit(Long accountId, Product product, Long containerId) {

        Account account = accountSpi.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));

        Company company = account.getCompany();

        //company = company.withContainerList(company.getContainerList().append(containerSpi.findById);



    }
}
