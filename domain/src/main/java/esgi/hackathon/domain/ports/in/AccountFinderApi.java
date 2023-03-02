package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.Company;
import io.vavr.control.Option;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountFinderApi {

    Option<Account> findById(Long id);

    List<Account> findAll();

    Option<Account> findByMailAddressAndPassword(String email, String password);

    Option<Account> findByMailAddress(String email);

}
