package extia.hackathon.postgres.repository;

import extia.hackathon.postgres.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountsEntity, Long> {

    AccountsEntity findByMailAddressAndPassword(String adress, String password);
}
