package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Account;
import io.vavr.control.Option;

public interface AccountNFCConnectionApi {
    Option<Account> connect(int[] idNFC);
}
