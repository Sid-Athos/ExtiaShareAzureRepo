package extia.hackathon.postgres.repository;

import extia.hackathon.postgres.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByMailAddressAndPassword(String adress, String password);

}
