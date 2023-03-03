package esgi.hackathon.domain.ports.out;

import esgi.hackathon.domain.functional.model.Account;
import io.vavr.control.Option;

import java.util.List;

public interface AccountPersistenceSpi extends PersistenceSpi<Account, Long> {
    Option<Account> findByMailAddressAndPassword(String email, String password);

    Option<Account> findByMailAddress(String email);

}
