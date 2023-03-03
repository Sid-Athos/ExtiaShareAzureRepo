package esgi.hackathon.domain.functional.service.account;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.ports.in.AccountNFCConnectionApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class AccountNFCConnectionService implements AccountNFCConnectionApi {

     private static final Logger LOGGER = Logger.getLogger(AccountNFCConnectionService.class.getName());

     private final AccountPersistenceSpi spi;

     @Override
     public Option<Account> connect(int[] idNFC) {
          return spi.findByNFC(idNFC);
     }
}
