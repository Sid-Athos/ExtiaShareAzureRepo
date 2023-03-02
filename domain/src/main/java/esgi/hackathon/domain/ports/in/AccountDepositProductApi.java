package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Product;

public interface AccountDepositProductApi {
    void deposit(Long accountId, Product product, Long containerId);

}
