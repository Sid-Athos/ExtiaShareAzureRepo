package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Account;
import io.vavr.control.Option;

import java.util.List;
import java.util.Optional;

public interface AccountFinderApi {

    Optional<Account> findById(Long id);

    List<Account> findAll();

    Option<Account> findByMailAddressAndPassword(String email, String password);

    Option<Account> findByMailAddress(String email);

}
