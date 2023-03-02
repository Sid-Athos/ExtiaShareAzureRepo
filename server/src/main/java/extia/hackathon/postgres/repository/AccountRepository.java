package extia.hackathon.postgres.repository;

import extia.hackathon.postgres.entity.AccountsEntity;
import io.vavr.control.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountsEntity, Long> {

    Option<AccountsEntity> findAccountEntityById(Long id);

    Option<AccountsEntity> findByMailAddressAndPassword(String address, String password);

}
