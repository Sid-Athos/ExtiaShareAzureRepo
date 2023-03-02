package esgi.hackathon.server.postgres.repository;

import esgi.hackathon.server.postgres.entity.AccountsEntity;
import io.vavr.control.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountsEntity, Long> {

    Option<AccountsEntity> findAccountEntityById(Long id);

    Option<AccountsEntity> findByMailAddressAndPassword(String address, String password);

}
