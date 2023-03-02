package esgi.hackathon.domain.functional.service.account;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.ports.in.AccountFinderApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class AccountFinderService implements AccountFinderApi {

    private final AccountPersistenceSpi spi;

    @Override
    public Option<Account> findById(Long id) {
        return spi.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return spi.findAll();
    }

    @Override
    public Option<Account> findByMailAddressAndPassword(String email, String password) {
        return spi.findByMailAddressAndPassword(email, password);
    }

    @Override
    public Option<Account> findByMailAddress(String email) {
        return spi.findByMailAddress(email);
    }
}
